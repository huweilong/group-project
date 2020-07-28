package com.huweilong.group.service.dto.system.output.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户信息结果
 * @author Alex
 */
@Data
@ApiModel(value = "系统用户信息结果")
public class UserInfoOutputDTO implements Serializable {
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
    @ApiModelProperty(value = "密码", required = true, example = "aasd")
    private String password;

    /**
     * md5密码盐
     */
    @ApiModelProperty(value = "md5密码盐", required = true, example = "123456")
    private String salt;

    /**
     * 数据版本
     */
    @ApiModelProperty(value = "数据版本", required = true, example = "1")
    private Integer version;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", required = true, example = "1")
    private Long createUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true, example = "1")
    private Date createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人", required = true, example = "1")
    private Long updateUser;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", required = true, example = "1")
    private Date updateTime;

    /**
     * 数据状态 0 正常 1 已删除
     */
    @ApiModelProperty(value = "数据状态 0 正常 1 已删除", required = true, example = "1")
    private Byte activeFlag;

    private List authorities;
}
