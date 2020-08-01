package com.huweilong.group.service.auth.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.huweilong.group.service.auth.entity.BasicsEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MyBatisPlusMeta 配置
 */
@Slf4j
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createUser", Long.class, 1L);
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateUser", Long.class, 1L);
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictInsertFill(metaObject, "updateUser", Long.class, 1L);
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}
