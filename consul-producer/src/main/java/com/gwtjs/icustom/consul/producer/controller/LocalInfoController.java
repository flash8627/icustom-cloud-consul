package com.gwtjs.icustom.consul.producer.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController @Api(value = "服务器信息接口")
public class LocalInfoController {
    
	@Value("${server.port}")
	private String port;
	
	@ApiOperation(value = "查询自身的服务id")
	@GetMapping(value = "/info/local", produces = "application/json;charset=UTF-8")
	public String getInfoLocal() {
		JSONObject jsonTemp = new JSONObject();
		jsonTemp.put("server", 9093);
		try {
			InetAddress address = InetAddress.getLocalHost();// 获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
			jsonTemp.put("address", address);
			String hostAddress = address.getHostAddress();// 192.168.0.121
			jsonTemp.put("hostAddress", hostAddress);
			jsonTemp.put("port", port);
			System.out.println("host Address:"+hostAddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return jsonTemp.toJSONString();
	}
	
}
