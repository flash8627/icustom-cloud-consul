package com.gwtjs.icustom.consul.consumer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用生产者服务
 */
@FeignClient("consul-producer")
public interface ProducerService {

    @GetMapping("/producer")
    String producer();
    
    @GetMapping("/info/local")
    String serverInfo();
    
}
