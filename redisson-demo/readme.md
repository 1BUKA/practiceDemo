# redis+redisson做分布式锁
1. [搭建redis集群](https://blog.csdn.net/qq_52553095/article/details/120935481)
2. 使用redisson实现分布式锁
3. 测试方案：
   - 通过sys_user.sql中新增一条数据，将num的值设为大于0.
   - 使用jmeter多个线程去跑。跑完后num值没有小于0的话就测试成功。