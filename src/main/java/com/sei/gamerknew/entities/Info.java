package com.sei.gamerknew.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Info {
    @TableId
    private String infoid;
    private int platform;
    private String producer;
    private String mainstaff;
    private String intro;
    private String imgsrc;

    public Info() {
    }



    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }


    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }


    @Override
    public String toString() {
        return "Info{" +
                "infoid='" + infoid + '\'' +
                ", platform=" + platform +
                ", producer='" + producer + '\'' +
                ", mainstaff='" + mainstaff + '\'' +
                ", intro='" + intro + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                '}';
    }
}
