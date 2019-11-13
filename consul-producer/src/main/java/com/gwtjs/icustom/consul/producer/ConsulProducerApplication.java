package com.gwtjs.icustom.consul.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDiscoveryClient //适用 consul和ZooKeeper
@SpringBootApplication
//提供swagger服务,同时扫描本项目 
@ComponentScan(basePackages="com.gwtjs.icustom.consul.swagger.config,springfox,com.gwtjs.icustom.consul.producer.controller")
@EnableScheduling
public class ConsulProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProducerApplication.class, args);
    }
    
}
