package com.huweilong.group.service.system.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.basics.global.ResultsMsg;
import com.huweilong.group.service.dto.system.input.user.LoginInputDTO;
import com.huweilong.group.service.dto.system.input.user.RegisterInputDTO;
import com.huweilong.group.service.dto.system.input.user.UserInfoInputDTO;
import com.huweilong.group.service.dto.system.output.user.LoginOutputDTO;
import com.huweilong.group.service.dto.system.output.user.RegisterOutputDTO;
import com.huweilong.group.service.dto.system.output.user.UserInfoOutputDTO;
import com.huweilong.group.service.system.SystemUserService;
import com.huweilong.group.service.system.entity.SystemUserEntity;
import com.huweilong.group.service.system.mapper.SystemUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 系统用户服务
 * @author Alex
 */
@Slf4j
@RestController
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUserEntity> implements SystemUserService {

    /**
     * 登录接口
     * @param input 系统登录参数
     * @return 系统登录结果
     */
    @Override
    @Transactional
    public Results<LoginOutputDTO> login(LoginInputDTO input) {
        log.debug(">>>>系统登录参数信息为:>>>>{}", JSON.toJSONString(input));

        // 返回信息
        LoginOutputDTO res = new LoginOutputDTO();

        // 封装查询条件
        QueryWrapper<SystemUserEntity> query = new QueryWrapper<>();
        query.and(wrapper -> wrapper.lambda().eq(SystemUserEntity :: getUsername, input.getLoginName())
                .or().eq(SystemUserEntity :: getPhone, input.getLoginName())
        );

        // 查询数据库
        SystemUserEntity userInfo = this.getOne(query, false);

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
     * @param input 系统注册参数
     * @return 系统注册结果
     */
    @Override
    @Transactional
    public Results<RegisterOutputDTO> register(@Valid RegisterInputDTO input) {
        log.debug(">>>>系统注册参数信息为:>>>>{}", JSON.toJSONString(input));
        return Results.SUCCESS();
    }

    /**
     * 根据条件查询用户列表
     * @param input 查询条件
     * @return 查询结果
     */
    @Override
    public Results<List<UserInfoOutputDTO>> queryList(UserInfoInputDTO input) {
        // 封装查询条件
        QueryWrapper<SystemUserEntity> query = new QueryWrapper<>();
        return null;
    }
}
