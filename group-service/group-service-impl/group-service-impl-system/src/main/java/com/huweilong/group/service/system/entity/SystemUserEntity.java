package com.huweilong.group.service.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 系统用户表
 * @author Alex
 */
@Data
@TableName("sys_user")
public class SystemUserEntity extends BasicsEntity {

    /**
     * 用户名
     */
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String username;

    /**
     * 密码
     */
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY, select = false)
    private String password;

    /**
     * md5密码盐
     */
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String salt;

    /**
     * 手机号
     */
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String phone;
}
