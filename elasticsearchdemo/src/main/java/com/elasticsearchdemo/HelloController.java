package com.elasticsearchdemo;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/elastic")
public class HelloController {

    @Autowired
    private JestClient jestClient;

    @PostMapping("/articles")
    public String index(@RequestBody Article article) {

        try {

        /*List<String> tags=new ArrayList<String>();
        tags.add("music");
        tags.add("sport");
        tags.add("movie");
        tags.add("photo");
        Article article1=new Article(1,
                "aa",
                "奥术大师多奥术大师多大师大水电费第三方按规定防守打法",
                "哈迪",
                "大概说法是否",
                tags);*/
            Index index = new Index.
                    Builder(article).
                    index("magazine").
                    type("articles").
                    id(article.getId().toString()).
                    build();
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @PostMapping("/articles/search")
    public Object search(@RequestBody String json) {
        Search search = null;
        SearchResult searchResult = null;
        try {
            search = new Search.
                    Builder(json).
                    addIndex("magazine").
                    addType("articles").
                    build();


            searchResult = jestClient.execute(search);
            System.out.println(searchResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
