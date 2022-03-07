package com.example.weizhunon.Controller;

import com.example.weizhunon.Dao.GoodsDao;
import com.example.weizhunon.Pojo.Goods;
import com.example.weizhunon.Server.IGoodsService;
import com.example.weizhunon.Utills.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    IGoodsService goodsService;
    @Autowired
    GoodsDao goodsDao;

    @GetMapping
    public R selectGoogs() {
        return new R(goodsService.list());
    }

    @GetMapping("/{id}")
    public R selectById(@PathVariable("id") Integer id) {
        return new R(goodsService.getById(id));
    }


    @PostMapping
    public R saveGoods(@RequestBody Goods goods) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        goods.setAddTime(timestamp);
        goods.setUpdTime(timestamp);
        return new R(goodsDao.insert(goods));
    }

    @PutMapping
    public R updateGoods(@RequestBody Goods goods) {
        // 2019-06-10 17:32:05.11
        goods.setAddTime(new Timestamp(System.currentTimeMillis()));
        return new R(goodsDao.updateById(goods));
    }

    @DeleteMapping
    public R deleteGoods(@RequestBody Goods goods) {
        return new R(goodsService.removeById(goods.getGoodsId()));
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable("id") Integer id) {
        return new R(goodsService.removeById(id));
    }


//    @DeleteMapping
//    public R delegeGoodsList(@RequestBody Map<String,Object> map) {
//        return new R(goodsService.removeByMap(map));
//    }
}
