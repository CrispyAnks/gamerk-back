package com.sei.gamerknew.services.impl;

import com.sei.gamerknew.entities.Game;
import com.sei.gamerknew.mapper.TagMapper;
import com.sei.gamerknew.services.TagService;
import com.sei.gamerknew.utils.TagList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TagServiceImpl implements TagService {
    @Mapper
    private TagMapper tagMapper;
    @Override
    public void updateTag(Game game) {
        HashMap<String, Integer> tagCode = TagList.getTagCode(game.getTag01(), game.getTag02(), game.getTag03());
        tagMapper.updateTag(game.getTagid(), tagCode.get(game.getTag01()), tagCode.get(game.getTag02()), tagCode.get(game.getTag03()));
    }
}
