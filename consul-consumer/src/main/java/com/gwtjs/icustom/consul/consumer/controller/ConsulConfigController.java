package com.gwtjs.icustom.consul.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConsulConfigController {

	/*
	 */
	@Value("${bar}")
	String fooBar;
	@Value("${active}")
	String active;

	@GetMapping("/get/consul/config")
	public String getConsulConfig() {
		return active+" : "+fooBar;
	}

}
