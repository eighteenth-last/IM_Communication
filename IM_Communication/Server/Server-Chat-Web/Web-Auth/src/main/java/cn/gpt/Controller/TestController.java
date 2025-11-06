package cn.gpt.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: Server
 * @BelongsPackage: cn.gpt.Controller
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-11-06  23:55
 * @Description: TODO
 * @Version: 1.0
 */

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String test() {
        return "Hello World!";
    }
}
