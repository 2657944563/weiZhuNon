package com.example.weizhunon.Pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    @TableId(type = IdType.AUTO)
    private Integer goodsId;

    private Integer catId;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsNumber;

    private Double goodsWeight;

    private String goodsBigLogo;

    private String goodsSmallLogo;

    private Date addTime;

    private Date updTime;
}