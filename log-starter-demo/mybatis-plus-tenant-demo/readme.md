# Saas与多租户
- 问题: 
    - [什么是saas](https://zh.wikipedia.org/wiki/%E8%BD%AF%E4%BB%B6%E5%8D%B3%E6%9C%8D%E5%8A%A1)    
    - [在saas系统中多租户的概念是如何运用的？](https://www.jianshu.com/p/fbfdeed45cb8)
        - 我的理解：一个saas系统有为多个企业服务，而这多个企业就相当于一个个租户，而租户的创建由系统管理平台进行，租户内的数据归属权仍然是基于角色进行，这样可以将各个企业之间的数据进行逻辑层面的隔离。
    - 与mybatis-plus的多租户组件如何搭配使用？
        - 多一个租户管理，通过租户管理去区分归属于哪个企业, 再通过sql注入的方式进行数据的隔离。

## 多租户概念与Mybatis-plus多租户插件

- 目的：引入多租户概念,为了解决和区分不同服务之间的日志。这里仅用于同一数据库的不同服务之间的日志保存。

- 分析结果： 其本质和userId没有什么区别，仅仅通过mybatis-plus多租户组件实现配置，自动SQL注入追加上对应sql语句。

- 核心组成：
    - Context上下文--保存租户id、获取租户id.(JUC包也行、TransmittableThreadLocal包也行)
    - 拦截器--获取对应的租户id
    - mybatis-plus的租户设置。(核心组件：MybatisPlusInterceptor)
- 参考：
    - [mybatis-plus官方demo](https://gitee.com/baomidou/mybatis-plus-samples/tree/master/mybatis-plus-sample-tenant)
    - [多租户概念解释](https://zh.wikipedia.org/wiki/%E5%A4%9A%E7%A7%9F%E6%88%B6%E6%8A%80%E8%A1%93)
    - [多租户](https://www.hxstrive.com/subject/mybatis_plus.htm?id=311)
