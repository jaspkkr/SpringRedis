package com.jaspreet.springredis.repository;

import com.jaspreet.springredis.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArticleRepository implements CrudRepository<Article, String> {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "Article";

    @Override
    public <S extends Article> S save(S article) {
        redisTemplate.opsForHash().put(KEY, article.getId(), article);
        return article;
    }

    @Override
    public Iterable<Article> findAll() {
        return (List<Article>) redisTemplate.opsForHash().values(KEY);
    }

    @Override
    public <S extends Article> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Article> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Article entity) {}

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {}

    @Override
    public void deleteAll(Iterable<? extends Article> entities) {}

    @Override
    public void deleteAll() {}

    @Override
    public Optional<Article> findById(String id) {return null;
    }

    @Override
    public void deleteById(String id) {}

}
