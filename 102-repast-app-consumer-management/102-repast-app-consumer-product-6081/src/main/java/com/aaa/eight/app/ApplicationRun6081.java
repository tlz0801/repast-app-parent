package com.aaa.eight.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 10:16
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.aaa.eight.app"})
public class ApplicationRun6081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6081.class,args);
    }
}
