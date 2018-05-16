package com.hj.feign.service;

import com.hj.feign.entity.User;
import com.hj.feign.fallback.UserServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * Created by niuruijing on 2018/4/25.
 */
//链接FeignClient 要负载的服务（服务名称）
@Service
@FeignClient(value = "user-server")
public interface HelloService {

    //要负载user-server服务中的/hello接口
    @RequestMapping("/hello")
    public String hello2();


    /**
     * RequestParam  RequestHeader  这些指定参数名称的注解，他们的value千万不能少
     * 在springmvc中这些注解会根据参数名来做为默认值
     * 但在feign中参数必须通过value属性来指名具体的参数名  value属性不能为空
     */

    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public String test1(@RequestParam("name")String name);

    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public User test2(@RequestHeader("name")String name,@RequestHeader("age")String age);

    @RequestMapping(value = "test3",method = RequestMethod.POST)
    public String test3(@RequestBody User user);

}
