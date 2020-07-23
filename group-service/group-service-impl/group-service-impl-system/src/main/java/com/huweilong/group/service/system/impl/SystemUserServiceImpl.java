package com.huweilong.group.service.system.impl;

import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.system.input.user.LoginInputDTO;
import com.huweilong.group.service.dto.system.output.user.LoginOutputDTO;
import com.huweilong.group.service.system.SystemUserService;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统用户服务
 * @author Alex
 */
@RestController
public class SystemUserServiceImpl implements SystemUserService {

    /**
     * 登录接口
     * @param input 系统登录参数
     * @return 系统登录结果
     */
    @Override
    public Results<LoginOutputDTO> login(LoginInputDTO input) {
        return Results.SUCCESS();
    }
}
