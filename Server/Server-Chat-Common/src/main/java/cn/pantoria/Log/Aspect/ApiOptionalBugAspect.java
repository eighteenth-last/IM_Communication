package cn.pantoria.Log.Aspect;

import cn.pantoria.Log.Antnotation.ApiOptionalLog;
import cn.pantoria.Utils.json.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Log.Aspect
 * @Author: 程序员Eighteen
 * @CreateTime: 2026-01-01  21:32
 * @Description: TODO
 * @Version: 1.0
 */

@Aspect
@Slf4j
@Component
public class ApiOptionalBugAspect {

    // 定义切点
    @Pointcut("@annotation(cn.pantoria.Log.Antnotation.ApiOptionalLog)")
    public void apiOptionalLog() {

    }

    // 环绕通知
    @Around("apiOptionalLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 请求开始时间
        long startTime = System.currentTimeMillis();

        // 获取请求的类和方法
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        // 请求入参
        Object[] args = joinPoint.getArgs();
        // 入参转json字符串
        String argJsonStr = Arrays.stream(args).map(toJsonStr()).collect(Collectors.joining(", "));

        // 功能描述信息
        String description = getApiOptionalLogDescription(joinPoint);

        log.info("请求开始：[{}]，入参：{}，请求类：{}，请求方法：{}", description,argJsonStr,className,methodName);

        // 执行切点方法
        Object result = joinPoint.proceed();

        //执行耗时
        long executionTime = System.currentTimeMillis() - startTime;

        // 打印出参的相关信息
       log.info("请求结束：[{}]，耗时：{}ms，返回结果：{}", description,executionTime,JsonUtils.toJsonString(result));
        return result;
    }


    private String getApiOptionalLogDescription(ProceedingJoinPoint joinPoint) {
        // 从ProceedingJoinPoint中获取MethodSigna
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 使用MethodSignature获取当前请求被注解的Method
        Method method = methodSignature.getMethod();
        // 从Method中提取ApiOptionalLog注解
        ApiOptionalLog apiOptionalLog = method.getAnnotation(ApiOptionalLog.class);

        return apiOptionalLog.description();
    }

    private Function<Object,String> toJsonStr() {
       return JsonUtils::toJsonString;
    }
}
