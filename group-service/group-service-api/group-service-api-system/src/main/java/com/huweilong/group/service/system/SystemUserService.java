package com.huweilong.group.service.system;

import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.system.input.user.LoginInputDTO;
import com.huweilong.group.service.dto.system.input.user.RegisterInputDTO;
import com.huweilong.group.service.dto.system.output.user.LoginOutputDTO;
import com.huweilong.group.service.dto.system.output.user.RegisterOutputDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    Results<LoginOutputDTO> login(@Valid @RequestBody LoginInputDTO input);

    /**
     * 注册接口
     * @param input 系统注册参数
     * @return 系统注册结果
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册接口", notes = "用于用户注册系统")
    Results<RegisterOutputDTO> register(@Valid @RequestBody RegisterInputDTO input);
}
