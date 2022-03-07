package com.example.weizhunon.Mapper;

import com.example.weizhunon.Pojo.CatId;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CatIdMapper {
    int deleteByPrimaryKey(Integer catId);

    int insert(CatId record);

    int insertSelective(CatId record);

    CatId selectByPrimaryKey(Integer catId);

    int updateByPrimaryKeySelective(CatId record);

    int updateByPrimaryKey(CatId record);
}