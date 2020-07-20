package com.huweilong.group;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 分布式基础设施 - Spring Cloud组件 - 分布式注册中心
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class GroupServiceImplTestApplication {
    public static void main(String[] args) {
        // Spring Boot快速启动程序
        SpringApplication.run(GroupServiceImplTestApplication.class, args);
    }
}
