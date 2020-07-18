package com.huweilong.group.service.dto.test.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 测试input对象
 * @author Alex
 */
@Data
@ApiModel(value = "测试input对象")
public class TestInput {
    /**
     * id
     */
    @ApiModelProperty(value = "id", required = true, example = "1")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", required = true, example = "Alex")
    private String name;
}
