package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



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

    @GetMapping("/blogs/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<BlogApp> blogOpt = blogAppService.findById(id);
        if(blogOpt.isEmpty()){
            return "redirect:/blogs";
        }
        model.addAttribute("blogdetail", blogOpt.get());
        return "blogs/blogdetail";
    }
    
    @GetMapping("/blogs/new")
    public String tasknew(Model model){
        model.addAttribute("blogsForm", new BlogAppForm());
        return "blogs/new";
    }

    @PostMapping("/blogs")
    public String createBlog(@ModelAttribute BlogAppForm blogForm) {
        blogAppService.add(blogForm);
        return "redirect:/tasks";
    }
}
