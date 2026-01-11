package org.example.io.serializable;

import java.io.Serializable;

/**
 * <b>描述：</b><p>商品类，用于测试序列化与反序列化
 *
 * <p><b>创建时间：</b><p>2026-01-11 22:11
 *
 * @author 朱兴宇
 * @version 1.0.0
 */
public class Goods implements Serializable {
    private String goodsName;
    private double goodsPrice;
    private String goodsId;

    public Goods(String goodsName, double goodsPrice, String goodsId) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsId='" + goodsId + '\'' +
                '}';
    }
}
