package com.example.weizhunon.Server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.weizhunon.Dao.GoodsDao;
import com.example.weizhunon.Dao.UserDao;
import com.example.weizhunon.Pojo.Goods;
import com.example.weizhunon.Pojo.User;
import com.example.weizhunon.Server.IGoodsService;
import com.example.weizhunon.Server.IUserServer;
import org.springframework.stereotype.Service;

@Service
public class GoodsSerice extends ServiceImpl<GoodsDao, Goods> implements IGoodsService {
}
