package com.gwtjs.icustom.consul.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <h2>基于Consul的key-value配置中心</h2> Key value application
 * <p>
 * Created in 2019 启用定时调度功能，Consul需要使用此功能来监控配置改变
 * 
 * @EnableDiscoveryClient 注解是将服务标记为客户端,可被发现注册并注册到consul上。
 *  @EnableScheduling 开启定时调度功能，也就是隔一段时间回去扫描配置中心，如果配置有发生，有通知并刷新有标记
 *  @RefreshScope的类或方法所引用的配置。
 * <p/>
 * @author aG
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class ConfigApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
	
}
