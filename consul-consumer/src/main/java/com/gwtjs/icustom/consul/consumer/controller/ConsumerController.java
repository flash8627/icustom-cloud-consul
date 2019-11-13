package com.gwtjs.icustom.consul.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gwtjs.icustom.consul.consumer.service.ProducerService;

/**
 * 消费者
 */
@RestController
public class ConsumerController {

    //@Autowired private ConsumerService consumerService;
    
    @Autowired(required=true)
    private ProducerService producerService;

    /*@GetMapping("/consumer")
    public String getProducer(){
        return consumerService.consumer();
    }*/

    @GetMapping("/server/info")
    public String getServerInfo(){
        return producerService.serverInfo();
    }
    
}
