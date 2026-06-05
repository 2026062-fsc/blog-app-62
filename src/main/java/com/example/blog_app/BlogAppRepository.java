package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogAppRepository {
    private final JdbcClient jdbcClient;

    public BlogAppRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<BlogApp> findAll(){
        return jdbcClient.sql("SELECT id, title, body, name FROM blogs").query(BlogApp.class).list();
    }

    public void save(BlogApp blogApp){
        jdbcClient.sql("INSERT INTO blogs (title, body, name) VALUES (:title, :body, :name)")
                .param("title", blogApp.getTitle())
                .param("body", blogApp.getBody())
                .param("name", blogApp.getName())
                .update();
    }
}
