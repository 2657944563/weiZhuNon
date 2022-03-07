package com.example.weizhunon.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weizhunon.Mapper.GoodsMapper;
import com.example.weizhunon.Mapper.UserMapper;
import com.example.weizhunon.Pojo.Address;
import com.example.weizhunon.Pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GoodsDao extends BaseMapper<Goods>, GoodsMapper {
}
