package com.hj.userserver.controller;

import com.hj.userserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by niuruijing on 2018/4/20.
 */
@RestController
public class UserController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    private String hello(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("hello-----host:"+serviceInstance.getHost()+",serviceId:"+serviceInstance.getServiceId());
        return "hello,world";
    }


    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public String test(@RequestParam String name){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("test1-----host:"+serviceInstance.getHost()+",serviceId:"+serviceInstance.getServiceId());
        return "hello,"+name;
    }

    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public User test(@RequestHeader String name,@RequestHeader String age){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        //User对象 必须要有默认的构造函数，否则feign根据json字符串转换user的时候会报异常
        logger.info("test2-----host:"+serviceInstance.getHost()+",serviceId:"+serviceInstance.getServiceId());
        return new User(name,age);
    }

    @RequestMapping(value = "test3",method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("test3-----host:"+serviceInstance.getHost()+",serviceId:"+serviceInstance.getServiceId());
        return "hello:"+user.getName()+",age:"+user.getAge();
    }


}
