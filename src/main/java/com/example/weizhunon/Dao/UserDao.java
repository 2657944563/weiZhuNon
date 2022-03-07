package com.example.weizhunon.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weizhunon.Mapper.UserMapper;
import com.example.weizhunon.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> , UserMapper {
}
