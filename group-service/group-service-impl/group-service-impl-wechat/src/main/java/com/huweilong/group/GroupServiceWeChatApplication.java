package com.huweilong.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 分布式服务 - 分布式服务实现 - 分布式微信服务
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class GroupServiceWeChatApplication {
    public static void main(String[] args) {
        // Spring Boot快速启动程序
        SpringApplication.run(GroupServiceWeChatApplication.class, args);
    }
}
