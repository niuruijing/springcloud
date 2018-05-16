package com.hj.ribbon.controller;

import com.hj.ribbon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuruijing on 2018/4/23.
 */
@RestController
public class ConsumerController {
    @Autowired
    UserService userService;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer(){
        return userService.userService();
    }
}
