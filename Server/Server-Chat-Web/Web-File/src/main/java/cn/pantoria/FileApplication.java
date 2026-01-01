package cn.pantoria;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.pantoria")
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
        System.out.println("\033[32m(ง •_•)ง File服务启动成功\033[0m\n"
                + "\033[36m____    __    ____  _______ .______           _______  __   __       _______ \n"
                + "\\   \\  /  \\  /   / |   ____||   _  \\         |   ____||  | |  |     |   ____|\n"
                + " \\   \\/    \\/   /  |  |__   |  |_)  |  ______|  |__   |  | |  |     |  |__   \n"
                + "  \\            /   |   __|  |   _  <  |______|   __|  |  | |  |     |   __|  \n"
                + "   \\    /\\    /    |  |____ |  |_)  |        |  |     |  | |  `----.|  |____ \n"
                + "    \\__/  \\__/     |_______||______/         |__|     |__| |_______||_______|\n"
                + "\033[0m");
    }
}
