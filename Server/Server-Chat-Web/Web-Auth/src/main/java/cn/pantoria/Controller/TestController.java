package cn.pantoria.Controller;

import cn.pantoria.Enum.ResponseEnum;
import cn.pantoria.Exception.BaseException;
import cn.pantoria.Log.Antnotation.ApiOptionalLog;
import cn.pantoria.Response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.pantoria.Controller
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-11-06  23:55
 * @Description: TODO
 * @Version: 1.0
 */

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    @ApiOptionalLog(description = "测试1-1")
    public Response test() {
//        throw new BaseException(ResponseEnum.USER_NOT_EXIST);
        return Response.success("Hello from Auth!");
    }
}
