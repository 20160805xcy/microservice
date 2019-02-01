package com.xcy.microserviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//声明这是一个Eureka server 服务
@EnableEurekaServer
@SpringBootApplication
public class MicroserviceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaApplication.class, args);
    }

}

