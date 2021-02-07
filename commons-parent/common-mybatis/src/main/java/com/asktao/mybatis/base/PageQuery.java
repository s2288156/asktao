package com.asktao.mybatis.base;

import com.asktao.lib.domain.AbstractPageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageQuery extends AbstractPageQuery {

    public <T> Page<T> createPage(Class<T> bean) {
        Page<T> page = new Page<>(getPage(), getLimit());
        String[] sorts = StringUtils.split(getSort(), SEPARATOR);
        Arrays.stream(sorts).forEach(sort -> {

        });

        return page;
    }

}
