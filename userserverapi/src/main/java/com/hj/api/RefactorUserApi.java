package com.hj.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by niuruijing on 2018/4/25.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RefactorUserApi {
    public static void main(String[] args) {
        SpringApplication.run(RefactorUserApi.class);
    }
}
