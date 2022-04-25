# spring-cloud-alibaba-samples
## 提要
* 由于官方的demo采用的是dubbo做RPC调用的形式做的demo，对其进行的改造demo进行改造为Openfeign的形式
* - [笔记](https://sugar-empress-dcb.notion.site/Seata-a1f4c42b8e564846a904532f8cc17b04)

## 准备环境

* 启动 Nacos server <br>
  [Nacos Server 下载地址](https://github.com/alibaba/nacos/releases)

需要2.0以上

> 下载最新版本Nacos Server, 本地启动Nacos

* 启动Seata Server <br>
  [Seata Server 下载地址](https://github.com/seata/seata/releases)

> 下载最新版本Seata Server, 本地启动Seata

## 使用组件介绍

* Nacos 注册中心
* Nacos 配置中心
* Open Feign REST 服务调用
* Seata 分布式事务解决方案

## 项目目录介绍

* sca-common 
* sca-customer 消费者
* sca-provider 服务提供者


## seata常见问题
- [github seata入门问题](https://github.com/seata/seata/issues/3026)
- [怎么解决 "can not register RM,err:can not connect to services-server."](https://github.com/seata/seata/issues/2522)
- [no available service 'default' found, please make sure registry config correct](https://github.com/seata/seata/issues/2521)
- [seata yml配置文件参数](https://github.com/seata/seata/blob/develop/script/client/spring/application.yml)
## 项目参考
- [Seata 官方demo](https://github.com/seata/seata-samples.git)


