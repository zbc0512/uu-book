package io.zbc.uu.book.controller;

import io.zbc.uu.book.entity.Goods;
import io.zbc.uu.book.entity.Result;
import io.zbc.uu.book.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/goods")
@Controller
public class GoodsController {

    @Autowired
    IGoodsService goodsService;

    @RequestMapping(value = "/getAllGoods", method = RequestMethod.POST)
    @ResponseBody
    public Result getAllGoods() {
        List<Goods> goods = goodsService.getAllGoods();
        if (goods == null || goods.isEmpty()) {
            return Result.failResult();
        }
        return Result.successResult(goods);
    }

    @RequestMapping(value = "/getGoodsByName", method = RequestMethod.POST)
    @ResponseBody
    public Result getGoodsByName(@RequestBody Goods goods) {
        List<Goods> goodsList = goodsService.getGoodsByName(goods.getGoodsName());
        if (goodsList == null || goodsList.isEmpty()) {
            return Result.failResult();
        }
        return Result.successResult(goodsList);
    }

    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    @ResponseBody
    public Result addGoods(@RequestBody Goods goods) {
        boolean result = goodsService.addGoods(goods);
        return result ? Result.successResult() : Result.failResult();
    }

}
