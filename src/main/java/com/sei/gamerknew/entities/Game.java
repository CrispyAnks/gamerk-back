package com.sei.gamerknew.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sei.gamerknew.utils.PlatformList;
import com.sei.gamerknew.utils.TagList;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;

@Data
public class Game {
    @TableId
    private String gameid;
    private String name;
    private Date reldate;
    private String infoid;
    private String tagid;
    @TableField(exist = false)
    private double rating;

    @TableField(exist = false)
    private String platform;
    @TableField(exist = false)
    private String producer;
    @TableField(exist = false)
    private String mainstaff;
    @TableField(exist = false)
    private String intro;
    @TableField(exist = false)
    private String imgsrc;
    @TableField(exist = false)
    private String tag01;
    @TableField(exist = false)
    private String tag02;
    @TableField(exist = false)
    private String tag03;

    public Game() {
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameid='" + gameid + '\'' +
                ", name='" + name + '\'' +
                ", reldate=" + reldate +
                ", infoid='" + infoid + '\'' +
                ", tagid='" + tagid + '\'' +
                ", rating=" + rating +
                ", platform=" + platform +
                ", producer='" + producer + '\'' +
                ", mainstaff='" + mainstaff + '\'' +
                ", intro='" + intro + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", tag01=" + tag01 +
                ", tag02=" + tag02 +
                ", tag03=" + tag03 +
                '}';
    }

    public void complete(Info info, Tag tag,Double rating){
        this.setIntro(info.getIntro());
        this.setImgsrc(info.getImgsrc());
        this.setPlatform(PlatformList.getPlatform(info.getPlatform()));
        this.setProducer(info.getProducer());
        this.setMainstaff(info.getMainstaff());
        HashMap<Integer, String> tagList = TagList.getTagList(tag.getTag01(), tag.getTag02(), tag.getTag03());
        this.setTag01(tagList.get(tag.getTag01()));
        this.setTag02(tagList.get(tag.getTag02()));
        this.setTag03(tagList.get(tag.getTag03()));
        this.rating = rating;
    }
}
