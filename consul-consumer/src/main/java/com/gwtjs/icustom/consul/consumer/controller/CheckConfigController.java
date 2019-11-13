package com.gwtjs.icustom.consul.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Rest controller
 * <p>
 * 在 consul 中动态变更配置后的访问数据接口查看配置是否更新
 * Created in 2019
 * <p/>
 *
 * @author aG
 */
@RestController
@RefreshScope
public class CheckConfigController {
	
    @Value("${author}")
    private String author;

    @Value("${age}")
    private String age;

    /**
     * Demo string.
     *
     * @return the string
     */
    @GetMapping("/check/data")
    public String checkData() {
        return author + " , " + age;
    }
    
    @GetMapping("/actuator/info")
    public String health(){
        return new Date().toString();
    }
}
