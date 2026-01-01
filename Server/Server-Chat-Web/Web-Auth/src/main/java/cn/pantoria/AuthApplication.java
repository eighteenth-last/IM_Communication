package cn.pantoria;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.pantoria")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
        System.out.println("\033[32m(ง •_•)ง Auth服务启动成功\033[0m\n"
                + "\033[36m____    __    ____  _______ .______             ___      __    __  .___________. __    __  \n"
                + "\\   \\  /  \\  /   / |   ____||   _  \\           /   \\    |  |  |  | |           ||  |  |  | \n"
                + " \\   \\/    \\/   /  |  |__   |  |_)  |  ______ /  ^  \\   |  |  |  | `---|  |----`|  |__|  | \n"
                + "  \\            /   |   __|  |   _  <  |______/  /_\\  \\  |  |  |  |     |  |     |   __   | \n"
                + "   \\    /\\    /    |  |____ |  |_)  |       /  _____  \\ |  `--'  |     |  |     |  |  |  | \n"
                + "    \\__/  \\__/     |_______||______/       /__/     \\__\\ \\______/      |__|     |__|  |__| \n"
                + "\033[0m");
    }
}
