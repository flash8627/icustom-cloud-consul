
# 公共组件，引用即可使用
一般为选择性使用，引用即可使用，如API接口暴露，只有在开发时使用

# 1 swagger
  project name:common-swagger
  预览地址：http://localhost:${port}/${context-path}/swagger-ui.html
  使用方式：在需要使用swagger2的地方添加扫描注解即可使用：
  ```
  @ComponentScan(basePackages="com.gwtjs.icustom.consul.swagger.config,springfox")
  ```
  http://localhost:8100/swagger-ui.html

# 2 common-consul-config-tool
  project name:consul-config-tool
  预览地址：无
  使用方式：各个项目单独引用此包，不用再写代码,直接获取key即可取到consul的配置中心的配置文件






