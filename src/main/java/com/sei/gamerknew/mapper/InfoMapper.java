package com.sei.gamerknew.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sei.gamerknew.entities.Info;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InfoMapper extends BaseMapper<Info> {

    @Select("select * from info where infoid=#{infoid}")
    Info findById(@Param("infoid") String infoId);

    @Update("update info set platform=#{platform}, producer=#{producer}, mainstaff=#{mainstaff}, intro=#{intro},imgsrc=#{imgsrc}  where infoid=#{infoid}")
    void updateInfo(@Param("infoid") String infoId, @Param("mainstaff") String mainStaff, @Param("producer") String producer, @Param("platform") int platform, @Param("intro") String intro, @Param("imgsrc") String imgSrc);

    @Insert("insert into info values (#{infoid}, #{platform}, #{producer},#{intro},#{mainstaff}, #{imgsrc})")
    void add(@Param("infoid") String infoId, @Param("platform") int platform, @Param("producer") String producer, @Param("intro") String intro, @Param("mainstaff") String mainStaff, @Param("imgsrc") String imgSrc);
}
