package com.sei.gamerknew.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sei.gamerknew.entities.Bio;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BioMapper extends BaseMapper<Bio> {

    @Insert("insert into bio values (#{bio_id}, #{gender}, #{intro}, #{img_src})")
    void add(@Param("bio_id") String bioId, @Param("gender") String gender, @Param("intro") String intro, @Param("img_src") String imgSrc);

    @Update("update bio set gender = #{gender}, intro = #{intro} where bioid = #{bioid}")
    void update(@Param("bioid") String bioid, @Param("gender") String gender, @Param("intro") String intro);

    @Update("update bio set imgsrc = #{imgsrc}")
    void updateAva(@Param("imgsrc") String imgSrc);

    @Select("select * from bio where bioid = #{bioid}")
    Bio getBio(@Param("bioid") String bioid);

    @Delete("delete from bio where bioid = #{bioid}")
    void delBio(String bioid);
}
