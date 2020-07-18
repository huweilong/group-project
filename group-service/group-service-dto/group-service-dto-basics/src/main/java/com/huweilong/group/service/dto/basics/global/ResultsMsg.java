package com.huweilong.group.service.dto.basics.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 通用接口返回内容
 * @author Alex
 */
@AllArgsConstructor
@Getter
public enum ResultsMsg {

    SUCCESS(200, "操作成功"),
    ERROR(500, "系统异常"),
    ;

    private Integer state;
    private String message;

    public static ResultsMsg getByCode(String state) {
        return Arrays.stream(ResultsMsg.values()).filter(a -> a.getState().equals(state)).findFirst().orElse(null);
    }

}
