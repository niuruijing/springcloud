package com.hj.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by niuruijing on 2018/4/23.
 */
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "userFallback")
    public String userService(){
        return restTemplate.getForEntity("http://USER-SERVER/hello",String.class).getBody();
    }

    public String userFallback(){
        return "error";
    }
}
