package com.jaspreet.springredis.controller;

import com.jaspreet.springredis.entity.Article;
import com.jaspreet.springredis.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticlesCont {


    @Autowired
    private ArticleService articleService;

    @PostMapping("/article")
    public String saveArticle(@RequestBody Article article){
        articleService.addArticle(article);
        return "Article Added to Redis";
    }

    @GetMapping("/article")
    public List<Article> getAllArticles(){
        return articleService.getArticles();
    }

}
