package com.example.weizhunon.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weizhunon.Mapper.CatIdMapper;
import com.example.weizhunon.Pojo.Address;
import com.example.weizhunon.Pojo.CatId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CatDao extends BaseMapper<CatId>, CatIdMapper {
}
