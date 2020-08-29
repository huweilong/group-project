package com.huweilong.group.service.auth.impl.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huweilong.group.service.auth.base.AuthUserService;
import com.huweilong.group.service.auth.entity.AuthUserEntity;
import com.huweilong.group.service.auth.mapper.AuthUserMapper;
import org.springframework.stereotype.Service;

/**
 * 认证用户服务接口实现
 * @author Alex
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUserEntity> implements AuthUserService {
}
