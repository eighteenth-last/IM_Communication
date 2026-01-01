package cn.pantoria.Exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Exception
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-11-07  21:07
 * @Description: 业务异常
 * @Version: 1.0
 */

@Getter
@Setter
public class BaseException extends RuntimeException{
    // 错误码
    private String errorCode;
    //错误信息
    private String errorMessage;

    public BaseException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
