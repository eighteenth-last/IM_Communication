package cn.pantoria.Controller;

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
    public Response test() {
        Response.fail("1314520","测试一下");
        return Response.success("Hello from Gateway!");
    }
}
