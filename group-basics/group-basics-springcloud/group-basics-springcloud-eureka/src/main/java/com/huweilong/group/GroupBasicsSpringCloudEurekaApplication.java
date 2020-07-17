package com.huweilong.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 分布式基础设施 - Spring Cloud组件 - 分布式注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class GroupBasicsSpringCloudEurekaApplication {
    public static void main(String[] args) {
        // Spring Boot快速启动程序
        SpringApplication.run(GroupBasicsSpringCloudEurekaApplication.class, args);
    }
}
