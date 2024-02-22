package com.jaspreet.springredis.service;

import com.jaspreet.springredis.entity.Article;
import com.jaspreet.springredis.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public Article addArticle(Article Article){
        return articleRepository.save(Article);
    }

    public List<Article> getArticles(){
        List<Article> articleList = new ArrayList<>();
        articleRepository.findAll().forEach(articleList::add);
        return articleList;
    }

}
