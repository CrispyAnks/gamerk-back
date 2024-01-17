package com.sei.gamerknew.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Mark {
    @TableId
    private String markid;
    private int status;
    private double rating;
    private String comment;

    private String userid;
    private String gameid;
    private Date commentdate;

    @TableField(exist = false)
    private String nickname;
    @TableField(exist = false)
    private String gamename;
    @TableField(exist = false)
    private String imgsrc;

    public Mark() {
    }

}
