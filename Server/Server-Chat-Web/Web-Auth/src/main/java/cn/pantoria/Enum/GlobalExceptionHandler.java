package cn.pantoria.Enum;

import cn.pantoria.Exception.BaseException;
import cn.pantoria.Response.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Exception
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-12-31  21:45
 * @Description: TODO
 * @Version: 1.0
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 捕获自定义异常
    @ExceptionHandler({BaseException.class})
    @ResponseBody
    public Response<Object> handleBizException(HttpServletRequest request, BaseException e) {
        log.warn("{} 请求出错，错误码{}，错误信息{}，",request.getRequestURI(),e.getErrorCode(),e.getErrorMessage());
        return Response.fail(e);
    }

    // 参数校验异常
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        // 参数错误异常码
        String errorCode = ResponseEnum.PARAM_ERROR.getErrorCode();

        // 获取bindingResult
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder stringBuilder = new StringBuilder();

        Optional.of(bindingResult.getFieldErrors()).ifPresent(errors -> {
            errors.forEach(error ->
                    stringBuilder.append(error.getField())
                            .append(" ")
                            .append(error.getDefaultMessage())
                            .append(",当前值： ")
                            .append(error.getRejectedValue())
                            .append(";")
            );
        });
        String errorMessage = stringBuilder.toString();

        log.warn("{} 请求出错，错误码{}，错误信息{}，",request.getRequestURI(),errorCode,errorMessage);

        return Response.fail(errorCode,errorMessage);
    }
    // 其他类型的异常
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Response<Object> handleException(HttpServletRequest request, Exception e) {
        log.error("{} 请求错误",request.getRequestURI(),e);
        return Response.fail(ResponseEnum.SYSTEM_ERROR);
    }
}
