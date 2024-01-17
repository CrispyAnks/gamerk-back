package com.sei.gamerknew.services;

import com.sei.gamerknew.entities.Game;

import java.util.List;

public interface GameService {
    Game findByGameId(String id);

    List<Game> getGameByPpl();

    List<Game> getGameByReldate();

    List<Game> getGameByPplNPlf(int platform);

    List<Game> getGame();

    void delGame(int gameId);

    void updateGame(Game game);

    void addNewGame(Game game);

    Game findByGameName(String name);
}
