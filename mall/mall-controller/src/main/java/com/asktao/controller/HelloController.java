package com.asktao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyang
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping("/say")
    public String say(String msg) {
        return "hello " + msg;
    }
}
