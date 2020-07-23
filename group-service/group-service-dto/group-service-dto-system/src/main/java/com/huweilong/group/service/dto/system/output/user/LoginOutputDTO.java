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
     * 登录令牌
     */
    @ApiModelProperty(value = "登录令牌", required = true, example = "aaaaaa")
    private String token;
}
