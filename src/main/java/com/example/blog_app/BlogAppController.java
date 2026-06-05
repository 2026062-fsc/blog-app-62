package com.example.blog_app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogAppController {

    private final BlogAppService blogAppService;

    public BlogAppController(BlogAppService blogAppService){
        this.blogAppService = blogAppService;
    }


    @GetMapping("/blogs")
    public String Allblogs(Model model) {
        List<BlogApp> blogList = blogAppService.findAll();

        model.addAttribute("blogList", blogList);
        return "blogs";
    }
    
}
