package com.huweilong.group.service.auth.config;

import com.huweilong.group.service.auth.handler.AuthFailureHandler;
import com.huweilong.group.service.auth.handler.AuthSuccessHandler;
import com.huweilong.group.service.auth.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 认证配置类
 * @author Alex
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 认证服务实现
     */
    private UserDetailsServiceImpl userDetailsServiceImpl;

    /**
     * 认证成功的处理方法
     */
    private AuthSuccessHandler authSuccessHandler;

    /**
     * 认证失败的处理方法
     */
    private AuthFailureHandler authFailureHandler;

    /**
     * 构造器
     * @param authSuccessHandler 认证成功的处理方法
     * @param authFailureHandler 认证失败的处理方法
     */
    @Autowired
    public SecurityConfig(
            AuthSuccessHandler authSuccessHandler,
            AuthFailureHandler authFailureHandler) {

        this.authSuccessHandler = authSuccessHandler;
        this.authFailureHandler = authFailureHandler;
    }

    /**
     * 注入器
     * @param userDetailsServiceImpl 认证服务实现
     */
    @Autowired
    public void setUserDetailsServiceImpl(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    /**
     * 密码服务
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * authenticationProvider
     * @return DaoAuthenticationProvider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsServiceImpl);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return authenticationProvider;
    }

    /**
     * 权限核心配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 开启formLogin模式
                .formLogin()
                // 用户未登录时，访问任何资源都跳转到该路径。即登登陆页面
//                .loginPage("/login.html")
                // 登陆表单form中的action地址，也是处理认证请求的路径
                .loginProcessingUrl("/user/login")
                // 默认是 username
                .usernameParameter("loginName")
                // 默认是 password
                .passwordParameter("password")
                // 登录成功跳转接口
//                .defaultSuccessUrl("/index")
                // 登陆失败跳转页面
//                .failureUrl("/login.html")
                // 登录成功 handler
//                .successHandler(authSuccessHandler)
                // 登录失败 handler
//                .failureHandler(authFailureHandler)

                .and()

                // 配置权限
                .authorizeRequests()
                .antMatchers("/oauth/**", "/user/login/**", "/user/register/**", "/user/logout/**", "/v2/**")
                // 用户可以任意访问
                .permitAll()
                // 需要对外暴漏的资源路径
//                .antMatchers("orger")
                // user admin角色都可以访问
//                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                // 需要对外暴漏的资源路径
//                .antMatchers("/systen/user", "/systen/role", "/systen/menu")
                // admin角色可以访问
//                .hasAnyAuthority("ROLE_ADMIN")
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()

                .and()

                .logout().logoutUrl("/user/logout")

                .and()

                .csrf().disable();
    }

    /**
     * 认证管理点配置
     * @param auth AuthenticationManagerBuilder
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }
}
