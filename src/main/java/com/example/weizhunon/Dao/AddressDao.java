package com.example.weizhunon.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weizhunon.Pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AddressDao extends BaseMapper<Address> {
}
