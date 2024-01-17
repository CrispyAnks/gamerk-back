package com.sei.gamerknew.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class News {
    @TableId
    private String newsid;
    private String title;
    private String src;
    private Date newsdate;

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsid='" + newsid + '\'' +
                ", title='" + title + '\'' +
                ", src='" + src + '\'' +
                ", newsdate=" + newsdate +
                '}';
    }
}
