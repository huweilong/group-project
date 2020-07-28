package com.huweilong.group.service.dto.system.output.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统登录结果
 * @author Alex
 */
@Data
@ApiModel(value = "系统登录结果")
public class LoginOutputDTO implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id", required = true, example = "1260928527571730433")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "admin")
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
