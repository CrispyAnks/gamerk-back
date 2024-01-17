package com.sei.gamerknew.services.impl;

import com.sei.gamerknew.entities.Game;
import com.sei.gamerknew.entities.Info;
import com.sei.gamerknew.mapper.InfoMapper;
import com.sei.gamerknew.services.InfoService;
import com.sei.gamerknew.utils.PlatformList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Mapper
    private InfoMapper infoMapper;

    @Override
    public Info getInfo(String infoId) {
        return infoMapper.findById(infoId);
    }

    @Override
    public void updateInfo(Game game) {
        infoMapper.updateInfo(game.getInfoid(), game.getMainstaff(), game.getProducer(), PlatformList.getPlatformCode(game.getPlatform()), game.getIntro(), game.getImgsrc());
    }
}
