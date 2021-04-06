package io.zbc.uu.book.service.impl;

import io.zbc.uu.book.dao.IGoodsInfoDao;
import io.zbc.uu.book.entity.GoodsInfo;
import io.zbc.uu.book.service.IGoodsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsInfoService implements IGoodsInfoService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsInfoService.class);

    @Autowired
    IGoodsInfoDao goodsInfoDao;

    @Override
    public List<GoodsInfo> getAllGoodsInfoList() {
        return goodsInfoDao.selectAllGoodsInfo();
    }

    @Override
    public List<GoodsInfo> getGoodsInfoByName(String goodsName) {
        return goodsInfoDao.selectGoodsInfoByName(goodsName);
    }

    @Override
    public boolean addGoodsInfo(GoodsInfo goodsInfo) {
        try {
            return goodsInfoDao.insertGoodsInfo(goodsInfo) > 0;
        } catch (Exception e) {
            logger.error("Add goods info failed, " + goodsInfo, e);
            return false;
        }
    }

}
