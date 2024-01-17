package com.sei.gamerknew.services;

import com.sei.gamerknew.entities.Game;
import com.sei.gamerknew.entities.Info;

public interface InfoService {
    Info getInfo(String infoId);

    void updateInfo(Game game);
}
