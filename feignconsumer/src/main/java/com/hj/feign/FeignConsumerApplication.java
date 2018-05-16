package com.hj.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by niuruijing on 2018/4/25.
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients  //开启Feign 功能
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class);
    }
}
