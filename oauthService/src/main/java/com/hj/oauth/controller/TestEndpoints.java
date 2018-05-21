package com.hj.oauth.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by niuruijing on 2018/5/9.
 * 测试oauth2.0 权限授权
 */
@RestController
public class TestEndpoints {

    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }

}
