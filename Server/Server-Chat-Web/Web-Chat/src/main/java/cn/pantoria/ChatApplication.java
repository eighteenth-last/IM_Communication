package cn.pantoria;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.pantoria")
public class ChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
        System.out.println("\033[32m(ง •_•)ง Chat服务启动成功\033[0m\n"
                + "\033[36m____    __    ____  _______ .______            ______  __    __       ___   .___________.\n"
                + "\\   \\  /  \\  /   / |   ____||   _  \\          /      ||  |  |  |     /   \\  |           |\n"
                + " \\   \\/    \\/   /  |  |__   |  |_)  |  ______|  ,----'|  |__|  |    /  ^  \\ `---|  |----`\n"
                + "  \\            /   |   __|  |   _  <  |______|  |     |   __   |   /  /_\\  \\    |  |     \n"
                + "   \\    /\\    /    |  |____ |  |_)  |        |  `----.|  |  |  |  /  _____  \\   |  |     \n"
                + "    \\__/  \\__/     |_______||______/          \\______||__|  |__| /__/     \\__\\  |__|     \n"
                + "\033[0m");
    }
}
