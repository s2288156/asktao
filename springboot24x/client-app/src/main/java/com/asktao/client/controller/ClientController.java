package com.asktao.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class ClientController {

    @GetMapping("/msg")
    public String msg() {
        return "hello client msg";
    }
}
