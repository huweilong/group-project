package com.huweilong.group.service.test;

import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.test.input.TestInput;
import com.huweilong.group.service.dto.test.output.TestOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 测试服务
 * @author Alex
 */
@RequestMapping("/demo")
@Api(tags = "测试服务")
public interface TestService {

    /**
     * path风格接口
     * @param id 编号
     * @return 返回结果
     */
    @GetMapping("/path/{id}")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "编号", required = true, dataType = "int", paramType = "path", example = "1")
    )
    @ApiOperation(value = "path风格接口", notes = "测试restfull风格的接口")
    public Results<TestOutput> testPathApi(@PathVariable Integer id);

    /**
     * post请求接口
     * @param testInput 参数
     * @return 返回结果
     */
    @PostMapping("/post")
    @ApiOperation(value = "post请求接口", notes = "测试post请求的接口")
    public Results<TestOutput> testPostApi(@RequestBody TestInput testInput);
}
