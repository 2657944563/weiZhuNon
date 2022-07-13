package com.example.weizhunon.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weizhunon.Dao.GoodsDao;
import com.example.weizhunon.Pojo.Goods;
import com.example.weizhunon.Pojo.GoodsInfo;
import com.example.weizhunon.Pojo.GoodsInner;
import com.example.weizhunon.Server.IGoodsService;
import com.example.weizhunon.Server.impl.GoodsInfoServer;
import com.example.weizhunon.Utills.R;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Random;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    IGoodsService goodsService;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    GoodsInfoServer goodsInfoServer;

    @GetMapping
    public R selectGoogs() {
        return new R(goodsService.list());
    }

    @GetMapping("/{id}")
    public R selectById(@PathVariable("id") Integer id) {
        final Goods byId = goodsService.getById(id);
        final GoodsInfo goodsInfo = goodsInfoServer.getOne(new QueryWrapper<GoodsInfo>().eq("goods_id", byId.getGoodsId()));
        return new R(new GoodsInner(byId, goodsInfo));
    }

    /**
     * 返回图片：获取商品id返回数据库图片名称，然后获取名称对应的图片
     *
     * @param response
     * @return
     */
    @SneakyThrows
    @GetMapping("images/{id}")
    public String readImage(HttpServletResponse response, @PathVariable String id) {
        ServletOutputStream out = null;
        FileInputStream ips = null;
        String path = ResourceUtils.getURL("classpath:").getPath() + "images";
        //获得本地项目的images真实路径
        String realPath = path.replace('/', '\\').substring(1, path.length());
        final Goods byId = goodsService.getById(id);
        try {
            //获取图片存放路径
            String imgPath = realPath + "\\" + byId.getGoodsBigLogo();
            ips = new FileInputStream(new File(imgPath));
            response.setContentType("image/png");
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
            ips.close();
        }
        return null;
    }

    //每页size个，返回第几currentPage页数据
    @GetMapping("page/{size}/{currentPage}")
    public R getPage(@PathVariable("currentPage") Integer currentPage, @PathVariable("size") Integer size) {
        Page<Goods> page = new Page<>(currentPage, size);
        return new R(goodsService.page(page));
    }

    /**
     * 上传商品，信息，图片
     *
     * @param goods
     * @param info
     * @param file
     * @return
     */
    @PostMapping
    public R saveGoods(Goods goods, @RequestParam(value = "Info", required = false) String info,
                       @RequestParam(value = "file", required = false) MultipartFile file,
                       @RequestParam(value = "file1", required = false) MultipartFile file1) {

        String imageName = "nul";
        String imageName1 = "nul";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        goods.setAddTime(timestamp);
        goods.setUpdTime(timestamp);
        //上传图片
        if (file != null && !file.isEmpty()) {
            imageName = loadImage(file);
        }
        if (file1 != null && !file1.isEmpty()) {
            imageName1 = loadImage(file1);
        }
        goods.setGoodsBigLogo(imageName);
        goods.setGoodsSmallLogo(imageName1);
        if ("nul1".equals(imageName) || "nul1".equals(imageName1)) {
            return new R(false).message("图片格式只支持jpg/jpeg/png!");
        }
        final int insert = goodsDao.Insert(goods);
        goodsInfoServer.save(new GoodsInfo(goods.getGoodsId(), info));
        return new R(insert);
    }

//    @PostMapping("list")
//    public R saveListGoods(GoodsList goodsList) {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        goodsService.saveBatch(goodsList.getGoods());
////        for (Goods goods : goodsList.getGoods()) {
////            goods.setAddTime(timestamp);
////            goods.setUpdTime(timestamp);
////            goodsDao.insert(goods);
////        }
//        return new R(true);
//    }

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

    /**
     * 上传图片，将图片名称和商品一起存入商品信息，shangping.jpg
     *
     * @param file
     * @return
     */
    @SneakyThrows
    public String loadImage(MultipartFile file) {
        //获得项目真实路径+图片文件夹路径
        String path = ResourceUtils.getURL("classpath:").getPath() + "images";
        //获得本地项目真实路径
        String realPath = path.replace('/', '\\').substring(1, path.length());
        //文件名
        String filename = file.getOriginalFilename();
        //判断是否是图片
        if (!filename.endsWith("png") &&
                !filename.endsWith("jpg") &&
                !filename.endsWith("jpeg")) {
            return "nul1";
        }
        //文件类型
        String contentType = file.getContentType();
        //文件名
        String s = System.currentTimeMillis() + "_" + new Random().nextInt(100) + "_" + filename;
        //创建文件对象
        File filePath = new File(realPath, s);
        // 如果存放路径的父目录不存在，就创建它。
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        //上传文件
        file.transferTo(filePath);
        if (filePath.exists()) {
            return s;
        }
        //返回消息
        return "nul";
    }


    //    @DeleteMapping
//    public R delegeGoodsList(@RequestBody Map<String,Object> map) {
//        return new R(goodsService.removeByMap(map));
//    }

    /**
     * 查询商品对应的信息
     *
     * @param id 商品id
     * @return
     */
    @GetMapping("info/{id}")
    public R getInfoById(@PathVariable("id") Integer id) {
        QueryWrapper<GoodsInfo> goodsInfoQueryWrapper = new QueryWrapper<>();
        goodsInfoQueryWrapper.eq("goods_id", id);
        GoodsInfo goodsInfo = goodsInfoServer.getOne(goodsInfoQueryWrapper);
        return new R(goodsInfo);
    }
}
