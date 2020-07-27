package com.huweilong.group.service.dto.system.input.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 系统注册参数
 * @author Alex
 */
@Data
@ApiModel(value = "系统注册参数")
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
}
