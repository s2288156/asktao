package com.asktao.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class ResourceController {

    @GetMapping("/msg")
    public String message() {
        return "msg1, msg2, msg3";
    }
}
