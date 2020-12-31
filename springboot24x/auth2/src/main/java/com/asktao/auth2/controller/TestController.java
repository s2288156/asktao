package com.asktao.auth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
