package cn.pantoria.Response;

import cn.pantoria.Exception.BaseException;
import cn.pantoria.Exception.BaseExceptionInterface;
import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Common
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-11-07  20:55
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class Response<T>implements Serializable {
    // 是否成功
    private boolean success= true;
    //响应给前端的消息
    private String message;
    // 响应异常码
    private String errorCode;
    // 响应数据
    private T data;

    //成功响应
    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    //失败响应
    public static <T> Response<T> fail(){
        Response<T> response = new Response<>();
        response.setSuccess(false);
        return response;
    }

    public static <T> Response<T> fail(String errorMessage){
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(errorMessage);
        return response;
    }

    public static <T> Response<T> fail(String errorCode, String errorMessage){
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(errorCode);
        response.setMessage(errorMessage);
        return response;
    }

    public static <T> Response<T> fail(BaseExceptionInterface e){
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(e.getErrorCode());
        response.setMessage(e.getErrorMessage());
        return response;
    }

    //业务异常
    public static <T> Response<T> fail(BaseException e){
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(e.getErrorCode());
        response.setMessage(e.getErrorMessage());
        return response;
    }
}
