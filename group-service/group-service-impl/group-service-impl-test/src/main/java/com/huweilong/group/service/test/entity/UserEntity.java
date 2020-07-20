package com.huweilong.group.service.test.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.huweilong.group.service.test.entity.em.UserSexEnum;
import lombok.Data;

import java.util.Date;

/**
 * @TableName
 *  value 表名
 *  schema schema
 *  keepGlobalPrefix 是否保持使用全局的 tablePrefix 的值(如果设置了全局 tablePrefix 且自行设置了 value 的值)
 *  resultMap xml中resultMap的id
 *  autoResultMap 是否自动构建resultMap并使用(如果设置resultMap则不会进行resultMap的自动构建并注入)
 *
 */
@Data
@TableName("user")
public class UserEntity {

    /**
     * @TableId 主键注解
     *  value 主键字段名
     *  type 主键类型
     *      IdType
     *      AUTO 数据库ID自增
     *      NONE 无状态,该类型为未设置主键类型(注解里等于跟随全局,全局里约等于 INPUT)
     *      INPUT insert前自行set主键值
     *      ASSIGN_ID 分配ID(主键类型为Number(Long和Integer)或String)(since 3.3.0),
     *          使用接口IdentifierGenerator的方法nextId
     *          (默认实现类为DefaultIdentifierGenerator雪花算法)
     *      ASSIGN_UUID	分配UUID,主键类型为String(since 3.3.0),
     *          使用接口IdentifierGenerator的方法nextUUID(默认default方法)
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * @TableField 字段注解(非主键)
     *  value 数据库字段名
     *  el 映射为原生#{...}逻辑,相当于写在xml里的#{...}部分
     *  exist 是否为数据库表字段
     *  condition 字段where实体查询比较条件,有值设置则按设置的值为准,没有则为默认全局的 %s=#{%s}
     *  update 字段update set部分注入, 例如：update="%s+1"：表示更新时会set version=version+1(该属性优先级高于el属性)
     *  insertStrategy FieldStrategy
     *      IGNORED 忽略判断
     *      NOT_NULL 非NULL判断
     *      NOT_EMPTY 非空判断(只对字符串类型字段,其他类型字段依然为非NULL判断)
     *      DEFAULT 追随全局配置
     *  updateStrategy FieldStrategy
     *      IGNORED 忽略判断
     *      NOT_NULL 非NULL判断
     *      NOT_EMPTY 非空判断(只对字符串类型字段,其他类型字段依然为非NULL判断)
     *      DEFAULT 追随全局配置
     *  whereStrategy FieldStrategy
     *      IGNORED 忽略判断
     *      NOT_NULL 非NULL判断
     *      NOT_EMPTY 非空判断(只对字符串类型字段,其他类型字段依然为非NULL判断)
     *      DEFAULT 追随全局配置
     *  fill 字段自动填充策略 FieldFill
     *      DEFAULT 默认不处理
     *      INSERT 插入时填充字段
     *      UPDATE 更新时填充字段
     *      INSERT_UPDATE 插入和更新时填充字段
     *  select 是否进行select查询
     *  keepGlobalFormat 是否保持使用全局的format进行处理
     *  jdbcType JDBC类型 (该默认值不代表会按照该值生效) JdbcType
     *  typeHandler 类型处理器 (该默认值不代表会按照该值生效) UnknownTypeHandler
     *  numericScale 指定小数点后保留的位数
     */
    @TableField
    private String name;

    /**
     * @EnumValue 通枚举类注解(注解在枚举字段上)
     */
    private Byte type;

    private UserSexEnum sex;

    private String email;


    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * @TableLogic 表字段逻辑处理注解（逻辑删除）
     *  value 逻辑未删除值
     *  delval 逻辑删除值
     */
    @TableLogic(value = "0", delval = "1")
    private Byte activeFlag;

    /**
     * @Version 乐观锁注解、标记 @Verison在字段上
     */
    @Version
    private Integer version;
}
