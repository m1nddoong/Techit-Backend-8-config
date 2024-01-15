package com.example.article;

import com.example.article.dto.ArticleDto;
import com.example.article.entity.Article;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

// 싱글톤 패턴
// 프로그램 전체에서 클래스의 구현체를 하나만 만들고 싶을떼


public class ArticleStoreSingleton {
    private final List<ArticleDto> articleDtoList = new ArrayList<>();

    private static ArticleStoreSingleton instance;
    ArticleStoreSingleton() {}

    public static ArticleStoreSingleton getInstance() {
        if (instance == null) {
            instance = new ArticleStoreSingleton();
        }
        return instance;
    }
}
