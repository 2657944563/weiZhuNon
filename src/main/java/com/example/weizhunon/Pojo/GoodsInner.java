package com.example.weizhunon.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInner {
    private Goods goods;
    private GoodsInfo goodsInfo;
}
