package com.huweilong.group.service.dto.auth.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 认证登录结果
 * @author Alex
 */
@Data
@ApiModel(value = "认证登录结果")
public class LoginOutputDTO implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id", required = true, example = "1289122790821068801")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "$2a$10$xFvtNDmqAxQ4sDfFNPp7c..1dBy1eagJUjHECtaJHbk2KD.CEYuOO")
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", required = true, example = "13165270713")
    private Integer phone;

    /**
     * 数据版本
     */
    @ApiModelProperty(value = "数据版本", required = true, example = "1")
    private Integer version;
}
