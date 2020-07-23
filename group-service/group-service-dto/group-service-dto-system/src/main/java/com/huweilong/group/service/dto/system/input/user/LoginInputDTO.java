package com.huweilong.group.service.dto.system.input.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 系统登录参数
 * @author Alex
 */
@Data
@ApiModel(value = "系统登录参数")
public class LoginInputDTO implements Serializable {
    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名", required = true, example = "admin")
    private String loginName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;
}
