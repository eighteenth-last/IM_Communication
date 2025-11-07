package cn.gpt.Exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.gpt.Exception
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-11-07  21:07
 * @Description: TODO
 * @Version: 1.0
 */

@Getter
@Setter
public class baseException extends RuntimeException{
    // 错误码
    private String errorCode;
    //错误信息
    private String errorMessage;

    public baseException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
