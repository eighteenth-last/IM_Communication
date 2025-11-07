package cn.gpt.Exception;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.gpt.Exception
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-11-07  21:05
 * @Description: TODO
 * @Version: 1.0
 */

public interface baseExceptionInterface {
    // 获取异常信息
    String getErrorMessage();

    // 获取异常码
    String getErrorCode();
}
