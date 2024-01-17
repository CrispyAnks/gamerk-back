package com.sei.gamerknew.controllers;

import com.sei.gamerknew.entities.Game;
import com.sei.gamerknew.entities.News;
import com.sei.gamerknew.entities.Result;
import com.sei.gamerknew.services.GameService;
import com.sei.gamerknew.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private GameService gameService;

    @GetMapping("/news")
    public Result<List<News>> getNews(){
        List<News> news = indexService.getNews();
        return Result.success(news);
    }

    @PostMapping("/search")
    public Result<List<Game>> getSearchResult(@RequestBody Game game){
        ArrayList<Game> games = new ArrayList<>();
        games.add(gameService.findByGameName(game.getName()));
        return Result.success(games);
    }


}
