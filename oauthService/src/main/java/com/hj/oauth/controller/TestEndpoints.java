package com.hj.oauth.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuruijing on 2018/5/9.
 * 测试oauth2.0 权限授权
 */
@RestController
public class TestEndpoints {


    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        //for debug
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        //for debug
       // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id : " + id;
    }

}
