package com.sei.gamerknew.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sei.gamerknew.entities.Mark;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MarkMapper extends BaseMapper<Mark> {
    @Select("select * from mark where userid = #{userid}")
    List<Mark> findMarkByUserId(@Param("userid") String userId);

    @Select("select * from mark where gameid = #{gameid}")
    List<Mark> findMarkByGameId(@Param("gameid") String gameId);

    @Select("select gameid from mark group by gameid order by count(*) desc limit 3")
    List<Mark> OrderByPpl();
    @Select("SELECT mark.gameid FROM mark LEFT JOIN game ON mark.gameid = game.gameid LEFT JOIN info ON game.infoid = info.infoid " +
            "WHERE platform = #{platform} GROUP BY mark.gameid ORDER BY COUNT(*) DESC LIMIT 3;")
    List<Mark> OrderByPplNPlf(@Param("platform") int platform);

    @Insert("insert into mark values (#{markid}, #{status}, #{rating}, #{comment}, NOW(), #{userid}, #{gameid})")
    void add(@Param("markid") String markId, @Param("status")int status, @Param("rating")double rating, @Param("comment")String comment, @Param("userid")String userId, @Param("gameid")String gameId);

    @Update("update mark set status=#{status}, rating=#{rating},comment=#{comment},commentdate=now() where markid=#{markid}")
    void update(@Param("markid") String markId, @Param("status") int status, @Param("rating") double rating, @Param("comment") String comment);

    @Delete("delete from mark where markid = #{markid}")
    void delMark(@Param("markid") String markId);

    @Select(" select AVG(rating) from mark where gameid = #{gameid}")
    Double getGameRating(@Param("gameid") String gameId);
}
