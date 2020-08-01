package com.huweilong.group.service.auth.config;

import com.huweilong.group.service.auth.AuthUserService;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserDetails implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthUserService authUserService;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        LoginInputDTO input = new LoginInputDTO();
        input.setLoginName(loginName);
        Results<LoginOutputDTO> results = authUserService.login(input);

        if (Results.isSuccess(results) && results.getContent() != null) {
            return new User(results.getContent().getUsername(), results.getContent().getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_NORMAL,ROLE_MEDIUM"));
        }

        throw new UsernameNotFoundException(Results.isSuccess(results) ? results.getMessage() : ResultsMsg.SEVER_ERROR.getMessage());
    }
}
