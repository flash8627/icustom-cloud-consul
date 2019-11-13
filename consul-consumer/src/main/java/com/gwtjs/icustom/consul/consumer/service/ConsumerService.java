package com.gwtjs.icustom.consul.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author zheng
 *
 */
@Service
public class ConsumerService {

    @Autowired(required=true)
    private ProducerService producerClient;

    public String consumer(){
        return producerClient.producer();
    }
    
    public String serverInfo() {
    	return producerClient.serverInfo();
    }


}
