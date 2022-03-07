package com.example.weizhunon.Server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.weizhunon.Dao.CatDao;
import com.example.weizhunon.Dao.UserDao;
import com.example.weizhunon.Pojo.CatId;
import com.example.weizhunon.Pojo.User;
import com.example.weizhunon.Server.ICatIdService;
import org.springframework.stereotype.Service;

@Service
public class ICatIdServer extends ServiceImpl<CatDao, CatId> implements ICatIdService {
}
