package com.blog.Dao;

import com.blog.entity.Link;

import java.util.List;

public interface LinkMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(Link record);

    int insertSelective(Link record);

    Link selectByPrimaryKey(Integer lid);

    Link selectByIdcard(String idcard);

    List<Link> selectByUid(Integer uid);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);

}