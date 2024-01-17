package com.sei.gamerknew.controllers;

import com.sei.gamerknew.entities.*;
import com.sei.gamerknew.services.GameService;
import com.sei.gamerknew.services.MarkService;
import com.sei.gamerknew.services.UserService;
import com.sei.gamerknew.utils.GetToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mark")
public class MarkController {
    @Autowired
    private UserService userService;
    @Autowired
    private MarkService markService;
    @Autowired
    private GameService gameService;

    @GetMapping("/user")
    public Result<PageBean<Mark>> userMark(
            @RequestHeader(name="Authorization") String token,
            int pageNum,
            int pageSize){
        User user = userService.findByUserId((String) GetToken.verifyToken(token).get("id"));
        if(user != null){
            return Result.success(markService.findByUserId(pageNum, pageSize));
        } else {
          return  Result.error("no such user!");
        }
    }

    @GetMapping("/game/{id}")
    public Result<PageBean<Mark>> gameMark(@PathVariable String id, int pageNum,
                                       int pageSize){
        if(gameService.findByGameId(id) != null){
            return Result.success(markService.findByGameId(id, pageNum, pageSize));
        }else {
            return Result.error("no such game");
        }
    }

    @PostMapping()
    public Result addMark(@RequestBody Mark mark){
        mark.setMarkid(UUID.randomUUID().toString());
        markService.markUp(mark);
        return Result.success();
    }

    @PutMapping ()
    public Result updateMark(@RequestBody Mark mark){
        
        markService.updateMark(mark);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id){
        markService.delMark(String.valueOf(id));
        return Result.success();
    }
}
