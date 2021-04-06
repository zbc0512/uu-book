package io.zbc.uu.book.controller;

import io.zbc.uu.book.entity.GoodsInfo;
import io.zbc.uu.book.entity.Result;
import io.zbc.uu.book.service.IGoodsInfoService;
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
    IGoodsInfoService goodsInfoService;

    @RequestMapping(value = "/getAllGoodsInfo/", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllGoodsInfo() {
        List<GoodsInfo> goodsInfoList = goodsInfoService.getAllGoodsInfoList();
        if (goodsInfoList == null || goodsInfoList.isEmpty()) {
            return Result.failResult();
        }
        return Result.successResult(goodsInfoList);
    }

    @RequestMapping(value = "/getGoodsInfoByName", method = RequestMethod.POST)
    @ResponseBody
    public Result getGoodsInfoByName(@RequestBody GoodsInfo goodsInfo) {
        List<GoodsInfo> goodsInfoList = goodsInfoService.getGoodsInfoByName(goodsInfo.getGoodsName());
        if (goodsInfoList == null || goodsInfoList.isEmpty()) {
            return Result.failResult();
        }
        return Result.successResult(goodsInfoList);
    }

    @RequestMapping(value = "/addGoodsInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result addGoodsInfo(@RequestBody GoodsInfo goodsInfo) {
        boolean result = goodsInfoService.addGoodsInfo(goodsInfo);
        return result ? Result.successResult() : Result.failResult();
    }

}
