package com.huweilong.group.service.auth.impl;

import com.huweilong.group.service.auth.UserBasicsService;
import com.huweilong.group.service.dto.auth.input.LoginInputDTO;
import com.huweilong.group.service.dto.auth.output.LoginOutputDTO;
import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.basics.global.ResultsMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * security 认证实现
 * @author Alex
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 用户基础服务
     */
    private UserBasicsService userBasicsService;

    /**
     * 注入器
     * @param userBasicsService 用户基础服务
     */
    @Autowired
    public UserDetailsServiceImpl(UserBasicsService userBasicsService) {
        this.userBasicsService = userBasicsService;
    }

    /**
     * security 默认认证入口
     * @param loginName 认证名
     * @return 认证结果
     * @throws UsernameNotFoundException 用户不存在异常
     */
    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        LoginInputDTO input = new LoginInputDTO();
        input.setLoginName(loginName);
        Results<LoginOutputDTO> results = userBasicsService.login(input);

        if (Results.isSuccess(results) && results.getContent() != null) {
            return new User(results.getContent().getUsername(), results.getContent().getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_NORMAL,ROLE_MEDIUM"));
        }

        throw new UsernameNotFoundException(Results.isSuccess(results) ? results.getMessage() : ResultsMsg.SEVER_ERROR.getMessage());
    }
}
