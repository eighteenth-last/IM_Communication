package com.gpt.server.Config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 程序员Eighteen
 * @CreateTime: 2025-10-26  18:25
 * @BelongsProject: Server
 * @Description: 配置openapi文档信息
 * @Version: 1.0
 */

@Configuration
public class Knife4jConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("🎓 智能考试系统API文档") // API文档标题，添加emoji图标
                        .description("📚 智能考试系统后端接口文档，提供完整的RESTful API服务\n\n" +
                                "✨ 主要功能模块：\n" +
                                "• 🧠 题目管理：支持选择题、判断题、简答题的增删改查\n" +
                                "• 📝 试卷管理：手动组卷和AI智能组卷\n" +
                                "• 🎨 轮播图管理：首页轮播图的图片上传和管理\n" +
                                "• 📊 考试记录：考试结果统计和分析\n" +
                                "• 🔔 公告管理：系统公告的发布和管理") // API文档描述，使用markdown格式
                        .version("v1.0.0") // API版本号
                        .contact(new Contact()
                                .name("🏫 程序员Eighteen") // 联系人姓名
                                .email("3273495516@qq.com") // 联系人邮箱
                                .url("http://localhost:8080")) // 联系人网址
                        .license(new License()
                                .name("Apache 2.0") // 许可证名称
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))); // 许可证URL
    }

    // 用户信息管理【两套结构】
    @Bean
    public GroupedOpenApi userAPI(){
        return GroupedOpenApi.builder().group("用户信息管理")
                .pathsToMatch(
                        "/api/user/**"
                ).build();
    }

    // 试题信息管理5+16=21
    @Bean
    public GroupedOpenApi questionAPI(){
        return GroupedOpenApi.builder().group("试题信息管理")
                .pathsToMatch(
                        "/api/categories/**",
                        "/api/question/**"
                ).build();
    }

    // 考试信息管理
    @Bean
    public GroupedOpenApi papersAPI(){
        return GroupedOpenApi.builder().group("考试信息管理")
                .pathsToMatch(
                        "/api/papers/**",
                        "/api/exams/**",
                        "/api/exam-records/**"
                ).build();
    }

    // 视频信息管理
    @Bean
    public GroupedOpenApi videosAPI(){
        return GroupedOpenApi.builder().group("视频信息管理")
                .pathsToMatch(
                        "/api/admin/videos/**",
                        "/api/videos/**",
                        "/api/video-categories/**"
                ).build();
    }

    // 系统信息管理
    @Bean
    public GroupedOpenApi systemAPI() {

        return GroupedOpenApi.builder().group("系统信息管理").
                pathsToMatch(
                        "/api/banners/**",
                        "/api/notices/**"
                ).
                build();
    }


    //6.其他信息管理（数据统计，文件查询，debug）四套接口 【实现文件查询】
    @Bean
    public GroupedOpenApi otherAPI() {

        return GroupedOpenApi.builder().group("其他内容管理").
                pathsToMatch(
                        "/api/stats/**",
                        "/files/**",
                        "/api/debug/**"
                ).
                build();
    }
}
