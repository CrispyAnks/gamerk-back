package com.sei.gamerknew.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Data
public class Bio {
    @TableId
    private String bioid;
    private String gender;
    private String intro;
    private String imgsrc;

    public Bio() {
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
        return "Bio{" +
                "id='" + bioid + '\'' +
                ", gender='" + gender + '\'' +
                ", intro='" + intro + '\'' +
                ", img_src='" + imgsrc + '\'' +
                '}';
    }
}
