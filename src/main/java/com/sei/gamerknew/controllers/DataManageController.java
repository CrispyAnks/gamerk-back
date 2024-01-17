package com.sei.gamerknew.controllers;

import com.sei.gamerknew.entities.Game;
import com.sei.gamerknew.entities.News;
import com.sei.gamerknew.entities.Result;
import com.sei.gamerknew.entities.User;
import com.sei.gamerknew.mapper.UserMapper;
import com.sei.gamerknew.services.*;
import com.sei.gamerknew.utils.GaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/manage")
public class DataManageController {
    @Autowired
    private GameService gameService;
    @Autowired
    private UserService userService;
    @Autowired
    private IndexService indexService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private TagService tagService;

    @GetMapping("/game")
    public Result<List<Game>> getGame(){
        List<Game> game = gameService.getGame();
        return Result.success(game);
    }

    @GetMapping("/user")
    public Result<List<User>> getUser(){
        List<User> user = userService.getUser();
        return Result.success(user);
    }

    @GetMapping("/news")
    public Result<List<News>> getNews(){
        List<News> news = indexService.getNews();
        return Result.success(news);
    }

    @DeleteMapping("/game")
    public Result delGame(@PathVariable int gameId){
        gameService.delGame(gameId);
        return Result.success();
    }

    @DeleteMapping("/user")
    public Result delUser(@RequestBody User user){
        userService.delUser(user);
        return Result.success();
    }
    @DeleteMapping("/news")
    public Result delNews(@PathVariable String newsId){
        indexService.delNews(newsId);
        return Result.success();
    }

    @PutMapping("/game")
    public Result updateGame(@RequestBody Game game){
        gameService.updateGame(game);
        infoService.updateInfo(game);
        tagService.updateTag(game);
        return Result.success();
    }

    @PutMapping("/news")
    public Result updateNews(@RequestBody News news){
        indexService.updateNews(news);
        return Result.success();
    }

    @PostMapping("/game")
    public Result addGame(@RequestBody Game game){
        if(gameService.findByGameName(game.getName()) == null){
            String id;
            while (true){
                id = GaUtils.geneId();
                if(gameService.findByGameId(id) == null){
                    break;
                }
            }
            game.setGameid(id);
            game.setInfoid("info" + game.getGameid());
            game.setTagid("tag" + game.getGameid());
            gameService.addNewGame(game);
            return Result.success();
        }else {
            return Result.error("game name invalid");
        }
    }

    @PostMapping("/news")
    public Result addNews(@RequestBody News news){
        news.setNewsid("news" + GaUtils.geneId());
        indexService.add(news);
        return Result.success();
    }
}
