package com.huweilong.group.service.test.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * @author Alex
 */
@Api(tags = "测试接口")
@RestController
public class TestController {
    @GetMapping("/normal")
    @ApiOperation(value = "normal", notes = "ROLE_NORMAL")
    @PreAuthorize("hasRole('ROLE_NORMAL')")
    public String normal( ) {
        return "normal permission test success !!!";
    }

    @GetMapping("/medium")
    @ApiOperation(value = "medium", notes = "ROLE_MEDIUM")
    @PreAuthorize("hasAuthority('ROLE_MEDIUM')")
    public String medium() {
        return "medium permission test success !!!";
    }

    @GetMapping("/admin")
    @ApiOperation(value = "admin", notes = "ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin() {
        return "admin permission test success !!!";
    }
}
