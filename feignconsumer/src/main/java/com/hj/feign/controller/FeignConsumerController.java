package com.hj.feign.controller;
import com.hj.feign.entity.User;
import com.hj.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuruijing on 2018/4/25.
 */
@RestController
public class FeignConsumerController {
    @Autowired
    HelloService helloService;


    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloService(){
        return helloService.hello2();
    }

    @RequestMapping(value = "/feign-test",method = RequestMethod.GET)
    public String hello2() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(helloService.hello2()).append("\n");
        stringBuffer.append(helloService.test1("niubaobao")).append("\n");
        stringBuffer.append(helloService.test2("niubaobao","20")).append("\n");
        stringBuffer.append(helloService.test3(new User("niubaobao","21"))).append("\n");
        return stringBuffer.toString();
    }
}
