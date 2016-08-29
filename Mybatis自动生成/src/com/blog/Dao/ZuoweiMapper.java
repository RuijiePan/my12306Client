package com.blog.Dao;

import com.blog.entity.Zuowei;

public interface ZuoweiMapper {
    int deleteByPrimaryKey(Integer zid);

    int insert(Zuowei record);

    int insertSelective(Zuowei record);

    Zuowei selectByPrimaryKey(Integer zid);

    int updateByPrimaryKeySelective(Zuowei record);

    int updateByPrimaryKey(Zuowei record);
}