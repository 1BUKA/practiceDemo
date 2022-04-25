# spring 缓存（Cache)

## Cache vs Buffer
|  Cache   | Buffer  |
|  ----  | ----  |
| The cache is based on Least Recently Used. | Buffer is based on First-In-First-Out. |
| It is the size of the page cache.  | 	It is an in-memory raw block I/O buffer. |
| It lived for a long period.  | 		It lived for a short period.|
| We read from the cache.  | 	We write into the buffer. |
| It stores the actual file data. | 	It stores the file metadata. |
| It improves read performance.  | 	It improves write performance. |

## spring中关于缓存的注解解释

- `@Cacheable`: 只缓存一次，下一次请求直接从缓存中获取。
- `@CacheEvict`: 用于清空缓存
- `@CachePut`: 用于执行方法时更新缓存中的数据
- `@Caching`: 用于执行以上多个注解操作，即复合操作注解。
- `@CacheConfig`: 作用于类上,抽取类中开头三个注解的公共配置。

## 在各个注解中，如何区分数据的不同？
- 通过注解的key属性进行判断，可以用方法中的参数进行判定而存储数据。
- 根据实验的结果表明，只有添加注解的方法才能从缓存中获取到对应的数据（默认情况下）【换成redis应该可以解决对应的问题】。

更多详情如，SpEL表达式的使用，Cache注解的自定义配置等等 
看参考文档中`spring 5.0 文档`的内容

## 缺陷
- 这种方式只适用于单机环境下并且并发量不高的时候才可用。
- 不推荐单独使用`@Cacheable`（它会跳过方法执行，直接返回缓存结果）与`@CachePut`,一般配合`@Cacheing`一起使用。


## 如何解决缺陷？

## 参考文档
- [spring-boot-caching javapoint](https://www.javatpoint.com/spring-boot-caching)
- [spring 5.0 文档](https://docs.spring.io/spring-framework/docs/5.0.0.M1/spring-framework-reference/htmlsingle/#cache)
- [springboot 关于缓存注解的相关配置文档](https://docs.spring.io/spring-boot/docs/current/reference/html/io.html#io.caching.provider.redis)
- [SpEL表达式的使用--官方文档](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/expressions.html)