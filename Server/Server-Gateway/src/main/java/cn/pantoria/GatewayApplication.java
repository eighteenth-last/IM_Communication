package cn.pantoria;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("\033[32m(ง •_•)ง 即时通讯网关启动成功\033[0m\n"
                + "\033[36m _______      ___   .___________. ___________    __    ____  ___   ____    ____ \n"
                + "/  _____|    /   \\  |           ||   ____\\   \\  /  \\  /   / /   \\  \\   \\  /   / \n"
                + "|  |  __     /  ^  \\ `---|  |----`|  |__   \\   \\/    \\/   / /  ^  \\  \\   \\/   /  \n"
                + "|  | |_ |   /  /_\\  \\    |  |     |   __|   \\            / /  /_\\  \\  \\_    _/   \n"
                + "|  |__| |  /  _____  \\   |  |     |  |____   \\    /\\    / /  _____  \\   |  |     \n"
                + " \\______| /__/     \\__\\  |__|     |_______|   \\__/  \\__/ /__/     \\__\\  |__|     \n"
                + "\033[0m");
    }
}