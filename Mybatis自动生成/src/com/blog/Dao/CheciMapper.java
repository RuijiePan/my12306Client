package com.blog.Dao;

import com.blog.entity.Checi;

public interface CheciMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Checi record);

    int insertSelective(Checi record);

    Checi selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Checi record);

    int updateByPrimaryKey(Checi record);
}