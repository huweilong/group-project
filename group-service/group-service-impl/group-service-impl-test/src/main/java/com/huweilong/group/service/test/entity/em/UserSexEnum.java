package com.huweilong.group.service.test.entity.em;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * 性别枚举
 * @author Alex
 */
@Getter
public enum UserSexEnum implements IEnum<Byte> {
    KNOW((byte) 0, "未知"),
    MAN1((byte) 1, "男"),
    WOMAN((byte) 2, "女");

    @EnumValue
    private Byte code;

    private String value;

    UserSexEnum(byte code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public Byte getValue() {
        return this.code;
    }
}
