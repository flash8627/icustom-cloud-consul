package com.gwtjs.icustom.consul.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "生产测试接口")
public class ProducerController {

	@ApiOperation(value = "查询自身的服务id")
	@GetMapping("/producer")
	public String producer() {
		System.out.println("I'm producer-9091-->");
		return "Hello, I'm producer-9091-->";
	}

}
