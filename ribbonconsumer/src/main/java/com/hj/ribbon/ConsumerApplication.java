package com.hj.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by niuruijing on 2018/4/23.
 */

/**
 * 或者直接省略EnableCircuitBreaker EnableDiscoveryClient SpringBootApplication
 * 用@SpringCloudApplication  包含以上注解
 */
@EnableCircuitBreaker  //开启断路器
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    @Bean
    @LoadBalanced  //LoadBalanced开启客户端负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }
}
