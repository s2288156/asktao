package com.mall.web.config;

import com.mall.lib.domain.ReturnCodeMsg;
import com.mall.lib.ex.BizException;
import com.mall.lib.ex.ResultCodeEnum;
import com.mall.lib.ex.SysException;
import com.mall.lib.util.JsonUtils;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * @author wcy
 */
@Configuration
@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        String result = "{}";
        try {
            result = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            log.error("feignClient = {}, errorMsg = {}", s, result);
            ReturnCodeMsg restResult = JsonUtils.fromJson(result, ReturnCodeMsg.class);
            if (restResult.getReturnMsg() == null || restResult.getReturnCode() == null) {
                return new BizException(ResultCodeEnum.SYS_EXECUTE_ERROR,
                        JsonUtils.fromJson(result, FeignErrorBody.class).getErrorDescription());
            }
            return new BizException(restResult.getReturnCode(), restResult.getReturnMsg());
        } catch (Exception e) {
            log.error("errorMsg toString ex: ", e);
            return new SysException(ResultCodeEnum.SYS_EXECUTE_ERROR, e.getLocalizedMessage());
        }
    }

}
