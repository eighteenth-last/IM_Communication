package cn.pantoria.Enum;

import cn.pantoria.Exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Enum
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-12-31  21:35
 * @Description: TODO
 * @Version: 1.0
 */

@Getter
@AllArgsConstructor
public enum ResponseEnum implements BaseExceptionInterface {
    // ======通用的异常枚举=======
    SYSTEM_ERROR("Getaway-001","系统异常"),
    // 参数异常
    PARAM_ERROR("Getaway-002","参数异常"),
    // Ip频繁访问
    IP_ERROR("Getaway-003","Ip频繁访问");


    // 获取异常码
    private final String errorCode;

    // 获取异常信息
    private final String errorMessage;
}
