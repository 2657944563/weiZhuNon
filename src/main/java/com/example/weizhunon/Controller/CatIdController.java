package com.example.weizhunon.Controller;

import com.example.weizhunon.Dao.CatDao;
import com.example.weizhunon.Pojo.CatId;
import com.example.weizhunon.Pojo.Goods;
import com.example.weizhunon.Server.ICatIdService;
import com.example.weizhunon.Utills.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("CatId")
public class CatIdController {
    @Autowired
    ICatIdService catIdService;

    @GetMapping
    public R selectAll() {
        return new R(catIdService.list());
    }

    @GetMapping("/{id}")
    public R selectById(@PathVariable("id") Integer id) {
        return new R(catIdService.getById(id));
    }

    @PostMapping
    public R saveGoods(@RequestBody CatId catId) {
        return new R(catIdService.save(catId));
    }

    @PutMapping
    public R updateGoods(@RequestBody CatId catId) {
        return new R(catIdService.updateById(catId));
    }

    @DeleteMapping
    public R deleteGoods(@RequestBody CatId catId) {

        return new R(catIdService.removeById(catId.getCatId()));
    }
    @DeleteMapping("/{id}")
    public R deleteGoods(@PathVariable Integer id) {
        return new R(catIdService.removeById(id));
    }
}
