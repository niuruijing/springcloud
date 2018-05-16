package com.hj.feign.fallback;

import com.hj.feign.entity.User;
import com.hj.feign.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by niuruijing on 2018/4/26.
 */
@Component
public class UserServiceFallback implements HelloService {

    @Override
    public String hello2() {
        return "error";
    }

    @Override
    public String test1(@RequestParam("name") String name) {
        return "error"+name;
    }

    @Override
    public User test2(@RequestHeader("name") String name, @RequestHeader("age") String age) {
        return new User("error","0");
    }

    @Override
    public String test3(@RequestBody User user) {
        return "error";
    }
}
