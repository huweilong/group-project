package com.huweilong.group.service.auth.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huweilong.group.service.auth.AuthUserService;
import com.huweilong.group.service.auth.entity.AuthUserEntity;
import com.huweilong.group.service.auth.mapper.AuthUserMapper;
import com.huweilong.group.service.dto.auth.input.LoginInputDTO;
import com.huweilong.group.service.dto.auth.input.RegisterInputDTO;
import com.huweilong.group.service.dto.auth.output.LoginOutputDTO;
import com.huweilong.group.service.dto.auth.output.RegisterOutputDTO;
import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.basics.global.ResultsMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

/**
 * 认证用户服务
 * @author Alex
 */
@Slf4j
@RestController
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUserEntity> implements AuthUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 登录接口
     * @param input 认证登录参数
     * @return 认证登录结果
     */
    @Override
    @Transactional
    public Results<LoginOutputDTO> login(@Valid LoginInputDTO input) {
        log.debug(">>>>系统登录参数信息为:>>>>{}", JSON.toJSONString(input));

        // 返回信息
        LoginOutputDTO res = new LoginOutputDTO();

        // 封装查询条件
        QueryWrapper<AuthUserEntity> query = new QueryWrapper<>();
        query.and(wrapper -> wrapper.lambda().eq(AuthUserEntity :: getUsername, input.getLoginName())
                .or().eq(AuthUserEntity :: getPhone, input.getLoginName())
        );

        // 查询数据库
        AuthUserEntity userInfo = this.getOne(query, false);

        // 判断用户是否存在
        if (userInfo == null) {
            return Results.RESULT(ResultsMsg.EMPTY);
        }

        // 封装返回信息并返回结果
        BeanUtils.copyProperties(userInfo, res);

        return Results.SUCCESS(res);
    }

    /**
     * 注册接口
     * @param input 认证注册参数
     * @return 认证注册结果
     */
    @Override
    public Results<RegisterOutputDTO> register(@Valid RegisterInputDTO input) {
        log.debug(">>>>系统注册参数信息为:>>>>{}", JSON.toJSONString(input));

        // 返回信息
        RegisterOutputDTO res = new RegisterOutputDTO();

        // 封装存储信息
        AuthUserEntity saveObj = new AuthUserEntity();
        BeanUtils.copyProperties(input, saveObj);
        saveObj.setSalt(UUID.randomUUID().toString());
        // 密码加密
        saveObj.setPassword(passwordEncoder.encode(input.getPassword()));
        this.save(saveObj);

        return Results.SUCCESS(res);
    }
}
