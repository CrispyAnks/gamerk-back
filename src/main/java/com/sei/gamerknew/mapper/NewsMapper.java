package com.sei.gamerknew.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sei.gamerknew.entities.News;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<News> {

    @Select("select * from news")
    List<News> findNews();

    @Delete("delete from news where newsid = #{newsid}")
    void delNews(@Param("newsid") String newsId);

    @Update("update news set newsdate=#{newsdate},title=#{title}, src=#{src} where newsid = #{newsid}")
    void updateNews(@Param("newid") String newsId, @Param("newsdate") Date newsDate, @Param("src") String src, @Param("title") String title);

    @Insert("insert into news values(#{newsid},#{title},#{src},#{newsdate})")
    void add(@Param("newsid") String newsId, @Param("title") String title, @Param("newsdate") Date newsDate, @Param("src") String src);
}
