package com.huweilong.group.service.dto.system.input.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户信息参数
 * @author Alex
 */
@Data
@ApiModel(value = "系统用户信息参数")
public class UserInfoInputDTO implements Serializable {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    private String username;
}
