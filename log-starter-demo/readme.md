# microservices-platform日志组件demo分析
- demo组成：它主要围绕以下展开。
    - 日志是否开启及其类型
    - 日志配置为db的模式时对数据库连接池的配置
    - 日志链路追踪
    - 对logback提供的适配器进行改造
- demo的缺陷：
    - 没获取到相对应的入参和出参数据记录在数据库中。
    - 没获取到各个阶段所需时长。
    
- 阅读demo的部分理解梳理
    - AduitLogAspect：审计日志切面 
        - @ConditionalOnClass: HttpServletRequest.class, RequestContextHolder.class 
            - Q: 这两个类在该切面中起什么作用
                - RequestContextHolder 获取请求的属性，相当于请求由它保存，仅是通过它拿出来这个请求。
                - HttpServletRequest 获取其请求头的信息
        - AuditLogProperties、IAuditService在这里的作用是什么？
            - AuditLogProperties是Java的配置文件，
                > @ConfigurationProperties(prefix="xxx")注解。可以通过该注解实现其他服务引用时，可以通过xxx.配置文件中的属性=sss,进行配置。
                > @RefreshScope 目的是修改nacos的配置文件时，如果该属性改变，则重加载。

    - IAuditService是 保存日志的接口
        - 两个实现：DbAuditServiceImpl（数据库）、LoggerAuditServiceImpl(打印在控制台)
        - 通过配置文件zlt.audit-log.log-type配置相对应的实现。
        - **注意：** 当为DbAuditServiceImpl模式时，要注意导入spring-boot-starter-jdbc的包.
        - 原因: @ConditionalOnClass(JdbcTemplate.class),判定了这个包是否存在，不存在就不创建了。对db进行操作也是基于jdbcTemplate去操作的。

    - MDCAdapter:  LogbackMDCAdapter   logback提供的拓展点
        - [MDC解释](http://www.alearner.top/index.php/2018/08/28/mdc-mapped-diagnostic-context/) 映射的诊断上下文（简称MDC）是用于区分来自不同源的交叉日志输出的工具。当服务器几乎同时处理多个客户端时，日志输出通常是交错的。 MDC基于每个线程进行管理。子线程自动继承其父级的映射诊断上下文的副本。
        - [官方解释](https://logback.qos.ch/manual/mdc.html)
        - [MDCAdapter源码分析](https://blog.csdn.net/caiguoxiong0101/article/details/105751009)
        - 作用： 一般与[TransmittableThreadLocal](https://juejin.cn/post/6998552093795549191)搭配使用，用于链路追踪，如日志链路追踪。

## 参考文章
- [(理论知识）Dapper-Google分布式跟踪系统](https://bigbully.github.io/Dapper-translation/)
- [链路追踪解决方案思路](https://zlt2000.gitee.io/2020-09-26-dubbo-traceId-select/)
- [日志组件demo参考](https://gitee.com/zlt2000/microservices-platform)