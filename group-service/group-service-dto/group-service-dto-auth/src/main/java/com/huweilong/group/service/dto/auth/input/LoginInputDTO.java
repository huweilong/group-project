package com.huweilong.group.service.dto.auth.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 认证登录参数
 * @author Alex
 */
@Data
@ApiModel(value = "认证登录参数")
public class LoginInputDTO implements Serializable {
    /**
     * 登录名
     */
    @NotBlank(message = "登录名不能为空")
    @ApiModelProperty(value = "登录名", required = true, example = "admin")
    private String loginName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;
}
