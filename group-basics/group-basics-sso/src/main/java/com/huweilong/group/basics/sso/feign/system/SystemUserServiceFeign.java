package com.huweilong.group.basics.sso.feign.system;

import com.huweilong.group.service.system.SystemUserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.Valid;

/**
 * 系统用户服务
 * @author Alex
 */
@FeignClient("group-service-system")
public interface SystemUserServiceFeign extends SystemUserService {
}
