package com.huweilong.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 分布式基础设施 - Spring Cloud组件 - 网关中心
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class GroupBasicsSpringCloudGatewayApplication {
    public static void main(String[] args) {
        // Spring Boot快速启动程序
        SpringApplication.run(GroupBasicsSpringCloudGatewayApplication.class, args);
    }
}
