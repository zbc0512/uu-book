package io.zbc.uu.book.service;

import io.zbc.uu.book.entity.Goods;

import java.util.List;

public interface IGoodsService {

    List<Goods> getAllGoodsList();

    List<Goods> getGoodsByName(String goodsName);

    boolean addGoods(Goods goods);
}
