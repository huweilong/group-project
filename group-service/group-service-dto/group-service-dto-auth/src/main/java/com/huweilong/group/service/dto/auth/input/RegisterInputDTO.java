package com.huweilong.group.service.dto.auth.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 认证注册参数
 * @author Alex
 */
@Data
@ApiModel(value = "认证注册参数")
public class RegisterInputDTO implements Serializable {
    /**
     * 用户名
     */
    @Size(max = 20, message = "用户名不能超过20个字符")
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    private String username;

    /**
     * 密码
     */
    @Size(min = 6, max = 18, message = "密码长度应该在6 - 18位之间")
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;

    /**
     * 手机号
     */
    @Size(max = 15, message = "手机号不能超过15位")
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号", required = true, example = "13165270713")
    private String phone;
}
