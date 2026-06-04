package com.example.blog_app;

public class BlogApp {
    private final Long id;
    private final String title;
    private final String body;
    private final String name;

    public BlogApp(Long id, String title, String body, String name){
        this.id = id;
        this.title = title;
        this.body = body;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getName() {
        return name;
    }
}
