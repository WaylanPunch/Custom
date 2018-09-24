package com.elasticsearchdemo;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "waylanpunch",type = "book")
public class Book {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String highlight;
    private List<String> tags;

    public Book() {
    }

    public Book(Integer id, String title, String content, String author, String highlight, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.highlight = highlight;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }


}
