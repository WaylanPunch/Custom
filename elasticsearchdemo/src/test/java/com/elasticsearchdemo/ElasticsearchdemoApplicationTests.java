package com.elasticsearchdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchdemoApplicationTests {

    //@Autowired
    //private ArticleRepository articleRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void contextLoads() {
        List<String> tags=new ArrayList<String>();
        tags.add("music");
        tags.add("sport");
        tags.add("movie");
        tags.add("photo");
        Book book=new Book(1,
                "aa",
                "奥术大师多奥术大师多大师大水电费第三方按规定防守打法",
                "哈迪",
                "大概说法是否",
                tags);
        bookRepository.index(book);
    }

}
