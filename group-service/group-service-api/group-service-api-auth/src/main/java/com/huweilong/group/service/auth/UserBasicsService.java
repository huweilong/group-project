package com.huweilong.group.service.auth;

import com.huweilong.group.service.dto.auth.input.LoginInputDTO;
import com.huweilong.group.service.dto.auth.input.RegisterInputDTO;
import com.huweilong.group.service.dto.auth.output.LoginOutputDTO;
import com.huweilong.group.service.dto.auth.output.RegisterOutputDTO;
import com.huweilong.group.service.dto.basics.global.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 用户基础服务
 * @author Alex
 */
@RequestMapping("/user/basics")
@Api(tags = "用户基础服务")
public interface UserBasicsService {

    /**
     * 登录接口
     * @param input 认证登录参数
     * @return 认证登录结果
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录接口", notes = "用于用户登录系统")
    Results<LoginOutputDTO> login(@Valid @RequestBody LoginInputDTO input);

    /**
     * 注册接口
     * @param input 认证注册参数
     * @return 认证注册结果
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册接口", notes = "用于用户注册系统")
    Results<RegisterOutputDTO> register(@Valid @RequestBody RegisterInputDTO input);
}
