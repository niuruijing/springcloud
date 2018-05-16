package com.hj.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by niuruijing on 2018/5/11.
 * 单点登录测试
 */
@RestController
public class OAuthTestController {

    @GetMapping("/login1")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/user")
    //public Principal user(Principal user) {
    //    return user;
    //}
    public String user() {
        return "abc";
    }
}
