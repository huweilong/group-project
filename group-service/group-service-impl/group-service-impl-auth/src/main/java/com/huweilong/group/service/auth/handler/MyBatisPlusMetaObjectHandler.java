package com.huweilong.group.service.auth.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MyBatisPlusMeta 配置
 * @author Alex-
 */
@Slf4j
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {
    /**
     * 数据插入时字段填充
     * @param metaObject 字段
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createUser", Long.class, 1L);
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateUser", Long.class, 1L);
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        log.info("end insert fill ....");
    }

    /**
     * 数据更新时字段填充
     * @param metaObject 字段
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictInsertFill(metaObject, "updateUser", Long.class, 1L);
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        log.info("end update fill ....");
    }
}
