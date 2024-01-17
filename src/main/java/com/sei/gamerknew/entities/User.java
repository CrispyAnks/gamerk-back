package com.sei.gamerknew.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class User {
    @TableId
    private String userid;
    @NotNull(groups = Add.class)
    @Pattern(regexp = "^¥¥S{1,10}$")
    private String username;
    @NotNull(groups = Add.class)
    private String password;
    private String bioid;
    @NotEmpty(groups = {Add.class, Update.class})
    @Pattern(regexp = "^¥¥S{1,10}$")
    private String nickname;

    @TableField(exist = false)
    private String gender;
    @TableField(exist = false)
    private String intro;
    @TableField(exist = false)
    private String imgsrc;

    public interface Update{

    }
    public interface Add{

    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bio_id='" + bioid + '\'' +
                ", gender='" + gender + '\'' +
                ", intro='" + intro + '\'' +
                ", img_src='" + imgsrc + '\'' +
                '}';
    }

    public void complete(Bio bio){
        this.setGender(bio.getGender());
        this.setIntro(bio.getIntro());
        this.setImgsrc(bio.getImgsrc());
    }
}
