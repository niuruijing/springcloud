package com.hj.feign.controller;
import com.hj.feign.entity.User;
import com.hj.feign.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuruijing on 2018/4/25.
 *
 */
@Api(value = "FeignConsumerController",description = "测试相关接口")
@RestController
//更新配置不需要重启
@RefreshScope
public class FeignConsumerController {
    @Autowired
    HelloService helloService;

    /**
     * @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
        @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
     * @return
     */
    @ApiOperation(value = "简单hello接口",httpMethod = "GET",notes = "获取测试展示的信息，响应示例："+"")
    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloService(){
        return helloService.hello2("1.0");
    }

    @RequestMapping(value = "/feign-test",method = RequestMethod.GET)
    public String hello2() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(helloService.hello2("1.0")).append("\n");
        stringBuffer.append(helloService.test1("niubaobao")).append("\n");
        stringBuffer.append(helloService.test2("niubaobao","20")).append("\n");
        stringBuffer.append(helloService.test3(new User("niubaobao","21"))).append("\n");
        return stringBuffer.toString();
    }
}
