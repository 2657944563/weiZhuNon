package com.example.weizhunon.Server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.weizhunon.Dao.GoodsInfoDao;
import com.example.weizhunon.Pojo.GoodsInfo;
import com.example.weizhunon.Server.IGoodsInfoService;
import org.springframework.stereotype.Service;

@Service
public class GoodsInfoServer extends ServiceImpl<GoodsInfoDao, GoodsInfo> implements IGoodsInfoService {
}
