package com.elasticsearchdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * https://www.elastic.co/guide/cn/elasticsearch/guide/current/_more_complicated_searches.html
 * https://docs.spring.io/spring-data/elasticsearch/docs/3.0.10.RELEASE/reference/html/#project
 *
 */

@SpringBootApplication
public class ElasticsearchdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchdemoApplication.class, args);
    }
}
