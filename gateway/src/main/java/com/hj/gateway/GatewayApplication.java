package com.hj.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by niuruijing on 2018/4/23.
 */

/**
 * 或者直接省略EnableCircuitBreaker EnableDiscoveryClient SpringBootApplication
 * 用@SpringCloudApplication  包含以上注解
 * EnableZuulProxy  开启zuul  api网关服务
 */
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {


    /*@Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }*/


    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class).web(true).run(args);
    }
}
