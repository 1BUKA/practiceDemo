# validator_demo
- 项目作用：简述了javax.validation.constrains包的使用及其自定义校验注解
- 启动项目后，如何其功能：
    - GET请求 获取实体类的初始化数据，该实体类含有用constrains包下注解。
        -  http://localhost:8080/getJson 
    - POST请求  将获取到的数据以json的形式填入，发送请求后看日志。
        - http://localhost:8080/checkParam
    - POST请求 自定义校验身份证的注解 
        - http://localhost:8080/checkCustomAnnotionParam
        - 请求体：{"idCard":"510921198707206211"} 

- 拦截类：ExceptionHandlerUtil。

- 需要导入的依赖：
```maven
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```