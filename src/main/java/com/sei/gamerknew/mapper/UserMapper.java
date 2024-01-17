package com.sei.gamerknew.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sei.gamerknew.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user values (#{userid}, #{username}, #{password}, #{bioid}, #{nickname})")
    void add(@Param("userid") String userId, @Param("username") String username, @Param("password") String password, @Param("bioid") String bioId, @Param("nickname") String nickname);

    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    @Select("select * from user where userid=#{userid}")
    User findByUserId(String userid);


    @Update("update user set nickname = #{nickname} where userid = #{userid}")
    void update(@Param("userid") String userId, @Param("nickname") String nickname);

    @Select("select * from user")
    List<User> getUsers();

    @Delete("delete from user where userid = #{userid}")
    void delUser(@Param("userid") String userId);
}
