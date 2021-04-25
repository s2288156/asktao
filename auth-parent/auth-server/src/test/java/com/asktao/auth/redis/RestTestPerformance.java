package com.asktao.auth.redis;

import com.asktao.auth.BaseWebTest;
import com.asktao.lib.constant.AuthConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author wcy
 */
@Slf4j
public class RestTestPerformance extends BaseWebTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY_TEST_PATH = "test:path";

    @Test
    void testPut() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Map<String, List<String>> testResource = new TreeMap<>();
        for (int i = 0; i < 10000; i++) {
            testResource.put("/a/" + i, Arrays.asList("ADMIN", "ROOT", "/a/" + i));
        }
        // * 只能匹配一级path，**可以匹配多级path
        testResource.put("/a/*", Arrays.asList("ADMIN", "ROOT", "/a/*"));
        testResource.put("/a/**", Arrays.asList("ADMIN", "ROOT", "/a/**"));
        redisTemplate.opsForHash().putAll(KEY_TEST_PATH, testResource);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
    }

    @Test
    void testGet() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        log.info("start == {}", System.currentTimeMillis());
        PathMatcher pathMatcher = new AntPathMatcher();
        Map<Object, Object> resourceRolesMap = redisTemplate.opsForHash().entries(KEY_TEST_PATH);
        Iterator<Object> iterator = resourceRolesMap.keySet().iterator();
        Set<String> authorities = new HashSet<>();
        log.info("while before == {}", System.currentTimeMillis());
        while (iterator.hasNext()) {
            String resourceUrlPattern = (String) iterator.next();
            if (pathMatcher.match(resourceUrlPattern, "/a/33/aa")) {
                authorities.addAll((ArrayList) resourceRolesMap.get(resourceUrlPattern));
            }
        }
        log.info("while after == {}", System.currentTimeMillis());
        Set<String> sets = authorities.stream()
                .map(i -> i = AuthConstant.AUTHORITY_PREFIX + i)
                .collect(Collectors.toSet());

        stopWatch.stop();
        System.out.println(sets);
        System.out.println(stopWatch.getTotalTimeSeconds());
        log.info("end");
    }
}
