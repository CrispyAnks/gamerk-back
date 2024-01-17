package com.sei.gamerknew.services;

import com.sei.gamerknew.entities.News;

import java.util.List;

public interface IndexService {
    List<News> getNews();

    void delNews(String newsId);

    void updateNews(News news);

    void add(News news);
}
