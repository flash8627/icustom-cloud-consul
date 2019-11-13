# icustom-cloud-consul

#项目列表

## boot-starters 公共启动项目
### boot-starter
  *启动项

## consul-common 公共组件模组

### common-swagger swagger服务接口项目
  *使用方式：添加依赖：
  ```
  <dependency>
	<groupId>com.gwtjs.icustom</groupId>
	<artifactId>common-swagger</artifactId>
	<version>${project.version}</version>
  </dependency>
  ```

  *启动类增加扫描：
  ```
  @ComponentScan(basePackages="com.gwtjs.icustom.consul.swagger.config,springfox,com.gwtjs.icustom.consul.producer.controller")
  ```
  测试地址：http://localhost:${port}/${context-path}/swagger-ui.html

### common-consul-config-tool consul配置中心工具
  抽象成单独工程，供其它项目共用，使用可以参考consul-config-server
    
## consul-config-server consul配置
  参考consul-consumer

## consul-producer - 生产者项目 

  测试方式:
  1.启动默认端口(9091,eclipse运行ConsulProducerApplication) 
  2.启动9092端口,dos方式运行 java -jar xxx.jar --server.port=9092
  3.启动9093端口,dos方式运行 java -jar xxx.jar --server.port=9093
  测试地址：
  1./info/local 
  2./producer

## consul-consumer - 消费者项目 

  测试地址：
  1.http://localhost:8082/server/info 获取生产者数据 实现负载均衡,获取的是consul-producer的/info/local
  
  检查配置中心配置的数据获取
  2./check/data 和consul-config-server共享的数据
  3./get/consul/config	单独的数据,测试不通过,配置中心无数据配置

## actuator-root
  ### actuator-server 服务端
  ### actuator-view-client 客户端，前端，视图化actuator数据。



# 整体测试-项目启动顺序 
  1.启动consul服务端(开发模式)
    consul agent -dev -ui -node=dzg
    预览地址：http://localhost:8500/ui/dc1/services

  2.启动生产者：
    consul-producer
    预览地址：

  3.启动消费者：
    consul-consumer
    配置中心预览地址：
      参考项目说明
    负载均衡测试地址：
      参考项目说明










