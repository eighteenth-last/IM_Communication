package cn.pantoria.Log.Antnotation;

import java.lang.annotation.*;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Log.Antnotation
 * @Author: 程序员Eighteen
 * @CreateTime: 2026-01-01  21:29
 * @Description: TODO
 * @Version: 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ApiOptionalLog {
    /**
     * 描述
     * @return
     */
    String description() default "";
}
