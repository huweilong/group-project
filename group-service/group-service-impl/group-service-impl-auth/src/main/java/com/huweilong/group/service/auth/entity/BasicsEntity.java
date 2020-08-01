package com.huweilong.group.service.auth.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据表公共字段
 * @author Alex
 */
@Data
public class BasicsEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 数据版本
     */
    @Version
    private Integer version;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT, insertStrategy = FieldStrategy.NOT_EMPTY)
    private Long createUser;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT, insertStrategy = FieldStrategy.NOT_EMPTY)
    private Date createTime;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, insertStrategy = FieldStrategy.NOT_EMPTY, updateStrategy = FieldStrategy.NOT_EMPTY)
    private Long updateUser;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, insertStrategy = FieldStrategy.NOT_EMPTY, updateStrategy = FieldStrategy.NOT_EMPTY)
    private Date updateTime;

    /**
     * 数据状态 0 正常 1 已删除
     */
    @TableLogic
    private Byte activeFlag;
}
