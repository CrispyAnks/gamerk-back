package com.sei.gamerknew.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Tag {
    @TableId
    private String tagid;
    private int tag01;
    private int tag02;
    private int tag03;

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagid='" + tagid + '\'' +
                ", tag01=" + tag01 +
                ", tag02=" + tag02 +
                ", tag03=" + tag03 +
                '}';
    }
}
