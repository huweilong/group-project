package com.huweilong.group.service.system;

import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.system.input.user.LoginInputDTO;
import com.huweilong.group.service.dto.system.output.user.LoginOutputDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统用户服务
 * @author Alex
 */
@RequestMapping("/user")
@Api(tags = "系统用户服务")
public interface SystemUserService {

    /**
     * 登录接口
     * @param input 系统登录参数
     * @return 系统登录结果
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录接口", notes = "用于用户登录系统")
    Results<LoginOutputDTO> login(@RequestBody LoginInputDTO input);
}
