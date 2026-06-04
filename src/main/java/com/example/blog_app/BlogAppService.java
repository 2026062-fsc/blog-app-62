package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlogAppService {
    private final BlogAppRepository blogAppRepository;
    public BlogAppService(BlogAppRepository blogAppRepository){
        this.blogAppRepository = blogAppRepository;
    }

    public List<BlogApp> findAll(){
        return blogAppRepository.findAll();
    }

    public void add(BlogAppForm form){
        if(form.getTitle() == null){
            throw new IllegalArgumentException("タイトルが空です");
        }
        if(form.getBody() == null){
            throw new IllegalArgumentException("ブログ内容がありません");
        }
        blogAppRepository.save(new BlogApp(null, form.getTitle(), form.getBody(), form.getName()));
    }
}
