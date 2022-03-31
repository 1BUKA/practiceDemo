# ElasticSearch
## 概述
- 数据分类：
    - 结构化数据（Mysql)
    - 半结构化数据(MongoDB,Redis)
    - 非结构化数据(MongoDB,Redis)
- 什么是ES？
    - 开源高拓展的全文分布式搜索引擎
    - 基于Lucene开发的
    - 还有什么其他的吗？ Solr也是全文搜索引擎

## 入门
- ELK是什么？
    - ElasticSearch： 全文搜索 9300内部集群通信端口、9200 http访问的端口
    - LogStash： 数据手机
    - Kibana: 界面展示
- [下载页面](https://www.elastic.co/cn/downloads/?elektra=home&storm=hero)

- 本地启动的相关配置
```markdown
账号： elastic 密码： egzEsN6frBXeNgMkzD5P
请求网址： https://127.0.0.1:9200

-> Authentication is enabled and cluster connections are encrypted.

->  Password for the elastic user (reset with `bin/elasticsearch-reset-password -u elastic`):
  egzEsN6frBXeNgMkzD5P

->  HTTP CA certificate SHA-256 fingerprint:
  d452af56faca3cfbfc81e69adc3963deb8311acdd6ea99910366d9f0b0830db0

->  Configure Kibana to use this cluster:
* Run Kibana and click the configuration link in the terminal when Kibana starts.
* Copy the following enrollment token and paste it into Kibana in your browser (valid for the next 30 minutes):
  eyJ2ZXIiOiI4LjEuMSIsImFkciI6WyIxMC4xMzUuMTM2Ljg5OjkyMDAiLCIxOTIuMTY4LjEuNzo5MjAwIl0sImZnciI6ImQ0NTJhZjU2ZmFjYTNjZmJmYzgxZTY5YWRjMzk2M2RlYjgzMTFhY2RkNmVhOTk5MTAzNjZkOWYwYjA4MzBkYjAiLCJrZXkiOiJmdHJ6M244QnlKNzM5bVkxamgwYTplUUpDUWNyVFE3aWJ6ZjdXRWpYTWx3In0=

->  Configure other nodes to join this cluster:
* On this node:
  - Create an enrollment token with `bin/elasticsearch-create-enrollment-token -s node`.
  - Uncomment the transport.host setting at the end of config/elasticsearch.yml.
  - Restart Elasticsearch.
* On other nodes:
  - Start Elasticsearch with `bin/elasticsearch --enrollment-token <token>`, using the enrollment token that you generated.
```
- ElasticSearch的概念类比：
    - ElasticSearch ==> mysql
    - Index(索引) ===>  DataBase
    - Type(类型) ===> Table(表） 这个概念在7.0版本被去掉了
    - Document(文档) ==> Row（行）
    - Field(字段) ==> Column(列)
    
- 倒排索引的理解：
    - 倒排索引是通过字段返回其数据库主键，相对应的正排索引则是通过主键ID获取想对应的信息。
    
- 基本使用
    - 索引操作：（索引相当于DB中的DataBase)
        - 通过postman用put请求发送 https://127.0.0.1:9200/index_name
