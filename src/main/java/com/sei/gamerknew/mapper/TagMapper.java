package com.sei.gamerknew.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sei.gamerknew.entities.Tag;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.ibatis.annotations.*;
import org.omg.CORBA.BAD_POLICY;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    @Insert("insert into tag values (#{tagid},#{tag01}, #{tag02},#{tag03})")
    void add(@Param("tagid") String tagId, @Param("tag01") int tag01, @Param("tag02") int tag02, @Param("tag03") int tag03);

    @Update("update tag set tag01=#{tag01}, tag02=#{tag02}, tag03=#{tag03} where tagid=#{tagid}")
    void updateTag(@Param("tagid") String tagId, @Param("tag01") int tag01, @Param("tag02") int tag02, @Param("tag03") int tag03);

    @Select("select * from tag where tagid = #{tagid}")
    Tag findByID(@Param("tagid") String tagid);
}
