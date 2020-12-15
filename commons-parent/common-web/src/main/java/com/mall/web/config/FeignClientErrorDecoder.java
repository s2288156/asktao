package com.mall.web.config;

import com.mall.lib.domain.ReturnCodeMsg;
import com.mall.lib.ex.BizException;
import com.mall.lib.util.JsonUtils;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author wcy
 */
@Configuration
@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        BizException bizException = null;
        try {
            String result = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            log.error("feignClient = {}, errorMsg = {}", s, result);
            ReturnCodeMsg restResult = JsonUtils.fromJson(result, ReturnCodeMsg.class);
            bizException = new BizException(restResult.getReturnMsg(), restResult.getReturnCode());
        } catch (IOException e) {
            log.error("errorMsg toString ex:", e);
        }
        return bizException;
    }
}
