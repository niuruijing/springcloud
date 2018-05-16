package com.hj.api.controller;

import com.hj.api.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by niuruijing on 2018/4/25.
 */
@RestController("/refactor")
public interface UserSerivce {

    //要负载user-server服务中的/hello接口
    //@RequestMapping("/hello")
    public String hello2();


    /**
     * RequestParam  RequestHeader  这些指定参数名称的注解，他们的value千万不能少
     * 在springmvc中这些注解会根据参数名来做为默认值
     * 但在feign中参数必须通过value属性来指名具体的参数名  value属性不能为空
     */

    @RequestMapping(value = "test6",method = RequestMethod.GET)
    public String test(@RequestParam("name")String name);

    @RequestMapping(value = "test7",method = RequestMethod.GET)
    public User test(@RequestHeader("name")String name, @RequestHeader("age")String age);

    @RequestMapping(value = "test8",method = RequestMethod.POST)
    public String test(@RequestBody User user);
}
