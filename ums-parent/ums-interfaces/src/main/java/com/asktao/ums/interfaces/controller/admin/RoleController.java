package com.asktao.ums.interfaces.controller.admin;

import com.asktao.lib.domain.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    @GetMapping("/all/uid")
    public RestResponse<?> all(@RequestHeader String uid) {

        return RestResponse.success();
    }
}
