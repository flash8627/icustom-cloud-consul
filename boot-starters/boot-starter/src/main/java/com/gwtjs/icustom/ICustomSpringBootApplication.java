package com.gwtjs.icustom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*
 * @ServletComponentScan(value = { "com.gwtjs.icustom.*.*.controller.*" })
 * 
 * @ComponentScan("/")
 */
public class ICustomSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ICustomSpringBootApplication.class, args);
	}

}
