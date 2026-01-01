package cn.pantoria.Exception;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Exception
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-11-07  21:05
 * @Description: 基础的异常接口
 * @Version: 1.0
 */

public interface BaseExceptionInterface {
    // 获取异常信息
    String getErrorMessage();

    // 获取异常码
    String getErrorCode();
}
