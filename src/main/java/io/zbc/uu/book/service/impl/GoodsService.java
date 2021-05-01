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
    IGoodsDao GoodsDao;

    @Override
    public List<Goods> getAllGoodsList() {
        return GoodsDao.selectAllGoods();
    }

    @Override
    public List<Goods> getGoodsByName(String goodsName) {
        return GoodsDao.selectGoodsByName(goodsName);
    }

    @Override
    public boolean addGoods(Goods goods) {
        try {
            return GoodsDao.insertGoods(goods) > 0;
        } catch (Exception e) {
            logger.error("Add goods failed, " + goods, e);
            return false;
        }
    }

}
