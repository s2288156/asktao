package com.mall.web.config;

import com.mall.lib.domain.RestResult;
import com.mall.lib.ex.BizException;
import com.mall.lib.ex.ResultCodeEnum;
import com.mall.lib.ex.SysException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author wcy
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ResponseEntity<?> handleBizException(BizException ex) {
        log.warn("[BizException]: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestResult.failed(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(SysException.class)
    public ResponseEntity<?> handleBizException(SysException ex) {
        log.error("[SysException]: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestResult.failed(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<?> bingEx(BindException e) {
        log.warn("校验异常字段filedName: {}", e.getFieldError().getField());
        return ResponseEntity.badRequest().body(RestResult.failed(ResultCodeEnum.USER_ERROR.code(),
                e.getFieldError().getDefaultMessage()));
    }

//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex) {
//        log.warn("[AccessDeniedException]: {}", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(RestResult.error(ResultCodeEnum.PERMISSION_ERROR));
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        log.error("[UnknownException]: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestResult.failed(ResultCodeEnum.SYS_EXECUTE_ERROR));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> handleFeignException(FeignException ex) {
        log.error("feign调用异常: {}", ex.getMessage());
        if (ex.responseBody().isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new String(ex.responseBody().get().array()));
        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(RestResult.failed(ResultCodeEnum.SYS_EXECUTE_ERROR));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleParamNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(RestResult.failed(ResultCodeEnum.USER_ERROR.code(), allErrors.get(0).getDefaultMessage()));
    }

}
