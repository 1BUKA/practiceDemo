package com.jay.es;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.index.engine.Engine;

import java.io.IOException;

public class ESTest_index_search {
    public static void main(String[] args) throws IOException {
        //账户密码等相关配置
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "egzEsN6frBXeNgMkzD5P"));
        RestClientBuilder restClientBuilder = RestClient.builder(
                new HttpHost("127.0.0.1", 9200, "http"));

        // 将相关的配置注入到restClientBuilder中
        restClientBuilder.setHttpClientConfigCallback(
                new RestClientBuilder.HttpClientConfigCallback() {
                    @Override
                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                    }
                }).build();

        // 配置rest顶层操作
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);
        // 配置索引
        GetIndexRequest getIndexRequest = new GetIndexRequest("index_key_name");
        // 获取索引
        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);

        // 相应结果
        System.out.println(getIndexResponse.getAliases());
        System.out.println(getIndexResponse.getMappings());
        System.out.println(getIndexResponse.getSettings());

        // 关闭ES客户端
        restHighLevelClient.close();
    }

}
