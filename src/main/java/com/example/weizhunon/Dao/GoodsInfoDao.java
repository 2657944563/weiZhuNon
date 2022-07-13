package com.example.weizhunon.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weizhunon.Mapper.GoodsInfoMapper;
import com.example.weizhunon.Pojo.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GoodsInfoDao extends BaseMapper<GoodsInfo>, GoodsInfoMapper {
}
