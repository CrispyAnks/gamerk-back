package com.sei.gamerknew.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sei.gamerknew.entities.Game;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface GameMapper extends BaseMapper<Game> {

    @Select("select * from game where gameid = #{gameid}")
    Game findById(@Param("gameid") String gameId);

    @Select("select * from game order by reldate limit 3")
    List<Game> OrderByReldate();

    @Select("Select * from game")
    List<Game> getGame();

    @Delete("delete from game where gameid=#{gameid}")
    void delete(@Param("gameid") String gameId);

    @Update("update game set name=#{name}, reldate=#{reldate} where gameid=#{gameid}")
    void update(@Param("gameid") String gameId, @Param("name") String name, @Param("reldate") Date relDate);

    @Select("select * from game where name=#{name}")
    Game findByName(@Param("name") String name);

    @Insert("insert into game values (#{gameid}, #{name}, #{reldate}, #{infoid}, #{tagid})")
    void add(@Param("gameid") String gameId, @Param("name") String name, @Param("reldate") Date relDate, @Param("infoid") String infoId, @Param("tagid") String tagId);
}
