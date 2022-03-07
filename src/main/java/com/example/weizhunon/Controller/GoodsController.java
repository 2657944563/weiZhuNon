package com.example.weizhunon.Controller;

import com.example.weizhunon.Dao.GoodsDao;
import com.example.weizhunon.Pojo.Goods;
import com.example.weizhunon.Server.IGoodsService;
import com.example.weizhunon.Utills.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable("id") Integer id) {
        return new R(goodsService.removeById(id));
    }

    @PostMapping
    public R saveGoods(@RequestBody Goods goods) {
        return new R(goodsDao.insert(goods));
    }

    @PutMapping
    public R updateGoods(@RequestBody Goods goods) {
        return new R(goodsDao.updateById(goods));
    }
}
