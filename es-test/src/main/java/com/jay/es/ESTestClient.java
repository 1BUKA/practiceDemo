package com.jay.es;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.springframework.core.io.ClassPathResource;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class ESTestClient {
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
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("index_key_name");
        // 创建索引
//        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        GetIndexResponse index_key_name = restHighLevelClient.indices().get(new GetIndexRequest("index_key_name"), RequestOptions.DEFAULT);
        System.out.println("response:\t"+index_key_name.getIndices());
//        boolean acknowledged = createIndexResponse.isAcknowledged();
//        System.out.println("索引创建是否成功:\t" + acknowledged);
        // 关闭ES客户端
        restHighLevelClient.close();
    }

}
