package com.huweilong.group.service.auth.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 认证用户表
 * @author Alex
 */
@Data
@TableName("auth_user")
public class AuthUserEntity extends BasicsEntity {

    /**
     * 用户名
     */
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String username;

    /**
     * 密码
     */
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
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
