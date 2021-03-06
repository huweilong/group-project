package com.huweilong.group.service.test.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * MybatisPlus配置类
 * @author Alex
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {MybatisPlusConfig.BASE_MAPPER_PACKAGES, MybatisPlusConfig.BASE_DAO_PACKAGES})
public class MybatisPlusConfig {
    /**
     * BASE_MAPPER_PACKAGES
     *  Mybatis Plus 接口扫描
     */
    public static final String BASE_MAPPER_PACKAGES = "com.huweilong.group.service.test.mapper";
    /**
     * BASE_DAO_PACKAGES
     *  自定义接口扫描
     */
    public static final String BASE_DAO_PACKAGES = "com.huweilong.group.service.test.dao";

    /**
     * paginationInterceptor：
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 攻击 SQL 阻断解析器、加入解析链 阻止恶意的全表更新删除
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);

        return paginationInterceptor;
    }

    /**
     * optimisticLockerInterceptor：乐观锁配置
     * @return OptimisticLockerInterceptor
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * customizer
     * @return Jackson2ObjectMapperBuilderCustomizer
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer(){
        return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    }
}
