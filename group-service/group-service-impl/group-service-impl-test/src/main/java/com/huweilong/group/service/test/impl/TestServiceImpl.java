package com.huweilong.group.service.test.impl;

import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.test.input.TestInput;
import com.huweilong.group.service.dto.test.output.TestOutput;
import com.huweilong.group.service.test.TestService;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 测试服务
 * @author Alex
 */
@RestController
public class TestServiceImpl implements TestService {
    /**
     * path风格接口
     * @param id 编号
     * @return 返回结果
     */
    @Override
    public Results<TestOutput> testPathApi(Integer id) {
        TestOutput testOutput = new TestOutput();
        testOutput.setId(Long.valueOf(id));
        testOutput.setName(UUID.randomUUID().toString());
        return Results.SUCCESS(testOutput);
    }

    /**
     * post请求接口
     * @param testInput 参数
     * @return 返回结果
     */
    @Override
    public Results<TestOutput> testPostApi(TestInput testInput) {
        TestOutput testOutput = new TestOutput();
        testOutput.setId(testInput.getId());
        testOutput.setName(testInput.getName());
        return Results.SUCCESS(testOutput);
    }
}
