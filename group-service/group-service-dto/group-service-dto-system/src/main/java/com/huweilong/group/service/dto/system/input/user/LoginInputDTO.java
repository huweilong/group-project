package com.huweilong.group.service.dto.system.input.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 系统登录参数
 * @author Alex
 */
@Data
@ApiModel(value = "系统登录参数")
public class LoginInputDTO implements Serializable {

    /**
     * 登录类型
     */
    @NotNull(message = "登录类型不能为空")
    @ApiModelProperty(value = "登录类型", notes = "1 用户名密码登录 2 token免密登录", required = true, example = "1")
    private Integer loginType;

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
