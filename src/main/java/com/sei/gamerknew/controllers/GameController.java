package com.sei.gamerknew.controllers;

import com.sei.gamerknew.entities.Game;
import com.sei.gamerknew.entities.Result;
import com.sei.gamerknew.services.GameService;
import com.sei.gamerknew.utils.PlatformList;
import com.sei.gamerknew.utils.TagList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/{id}")
    public Result<Game> getGameById(@PathVariable int id){
        Game game = gameService.findByGameId(String.valueOf(id));
        return Result.success(game);
    }

    @GetMapping("/hot")
    public Result<List<Game>> getGameByPpl(){
        List<Game> gameByPpl = gameService.getGameByPpl();
        return Result.success(gameByPpl);
    }

    @GetMapping("/new")
    public Result getGameByDate(){
        List<Game> gameByReldate = gameService.getGameByReldate();
        return Result.success(gameByReldate);
    }

    @GetMapping("/cata/{platform}")
   public Result getGameByPlf(@PathVariable int platform){
        List<Game> gameByPplNPlf = gameService.getGameByPplNPlf(platform);
        return Result.success(gameByPplNPlf);
    }
}
