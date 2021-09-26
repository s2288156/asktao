package com.asktao.controller;

import com.asktao.auth.client.IAuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyang
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    private IAuthClient authClient;

    @GetMapping("/say")
    public String say(String msg) {
        return "hello " + authClient.publicKey().getData();
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong....";
    }
}
