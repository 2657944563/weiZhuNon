package com.example.weizhunon.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goodsInfo")
public class GoodsInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer goodsId;

    private String goodsInfo;

    public GoodsInfo(Integer goodsId, String goodsInfo) {
        this.goodsId = goodsId;
        this.goodsInfo = goodsInfo;
    }
}