package com.sei.gamerknew.services;

import com.sei.gamerknew.entities.Mark;
import com.sei.gamerknew.entities.PageBean;

import java.util.List;

public interface MarkService {
    PageBean<Mark> findByUserId(int pageNum, int pageSize);

    PageBean<Mark> findByGameId(String gameId, int pageNum, int pageSize);

    void markUp(Mark mark);

    void updateMark(Mark mark);

    void delMark(String markId);
}
