package io.zbc.uu.book.service.impl;

import io.zbc.uu.book.dao.IGoodsDao;
import io.zbc.uu.book.entity.Goods;
import io.zbc.uu.book.service.IGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService implements IGoodsService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsService.class);

    @Autowired
    IGoodsDao goodsDao;

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.selectAllGoods();
    }

    @Override
    public List<Goods> getGoodsByName(String goodsName) {
        return goodsDao.selectGoodsByName(goodsName);
    }

    @Override
    public boolean addGoods(Goods goods) {
        try {
            return goodsDao.insertGoods(goods) > 0;
        } catch (Exception e) {
            logger.error("Add goods failed, " + goods, e);
            return false;
        }
    }

}
