package com.huweilong.group.basics.sso.feign.system;

import com.huweilong.group.service.dto.basics.global.Results;
import com.huweilong.group.service.dto.system.input.user.LoginInputDTO;
import com.huweilong.group.service.dto.system.input.user.RegisterInputDTO;
import com.huweilong.group.service.dto.system.output.user.LoginOutputDTO;
import com.huweilong.group.service.dto.system.output.user.RegisterOutputDTO;
import com.huweilong.group.service.system.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 系统用户服务
 * @author Alex
 */
@FeignClient("group-service-system")
public interface SystemUserServiceFeign extends SystemUserService {
}
