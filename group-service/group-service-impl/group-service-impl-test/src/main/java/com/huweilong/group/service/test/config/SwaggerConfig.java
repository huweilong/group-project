package com.huweilong.group.service.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean(value = "testApi")
    @Order(value = 1)
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huweilong.group.service.test"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("分布式服务 - 分布式测试服务")
                .description("分布式服务 - 分布式测试服务")
                .termsOfServiceUrl("http://www.huweilong.com/")
                .contact("Alex_2713@126.com")
                .version("1.0.0")
                .build();
    }
}
