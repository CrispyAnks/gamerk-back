package com.sei.gamerknew.services.impl;

import com.sei.gamerknew.entities.News;
import com.sei.gamerknew.mapper.NewsMapper;
import com.sei.gamerknew.services.IndexService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public List<News> getNews() {
        return newsMapper.findNews();
    }

    @Override
    public void delNews(String newsId) {
        newsMapper.delNews(newsId);
    }

    @Override
    public void updateNews(News news) {
        newsMapper.updateNews(news.getNewsid(), news.getNewsdate(), news.getSrc(), news.getTitle());
    }

    @Override
    public void add(News news) {
        newsMapper.add(news.getNewsid(), news.getTitle(), news.getNewsdate(), news.getSrc());
    }
}
