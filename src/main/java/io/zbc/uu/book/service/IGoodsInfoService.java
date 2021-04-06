package io.zbc.uu.book.service;

import io.zbc.uu.book.entity.GoodsInfo;

import java.util.List;

public interface IGoodsInfoService {

    List<GoodsInfo> getAllGoodsInfoList();

    List<GoodsInfo> getGoodsInfoByName(String goodsName);

    boolean addGoodsInfo(GoodsInfo goodsInfo);
}
