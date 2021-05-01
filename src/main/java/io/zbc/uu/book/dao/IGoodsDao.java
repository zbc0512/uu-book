package io.zbc.uu.book.dao;

import io.zbc.uu.book.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IGoodsDao {

    @Select("SELECT * FROM goods")
    List<Goods> selectAllGoods();

    @Select("SELECT * FROM goods WHERE goods_id = #{goodsId}")
    Goods selectGoodsById(Integer goodsId);

    @Select("SELECT * FROM goods WHERE goods_name like concat('%', #{goodsName}, '%')")
    List<Goods> selectGoodsByName(String goodsName);

    @Insert("INSERT INTO `price_list`.`goods` ( " +
            "`goods_name`, `goods_price`, `quantity`, `unit`, `spec`, `type`, `supermarket`, `record_date` )" +
            "VALUES" +
            "(#{goodsName}, #{goodsPrice}, #{quantity}, #{unit}, #{spec}, #{type}, #{supermarket}, #{recordDate})")
    Integer insertGoods(Goods Goods);

    @Update("")
    int updateGoods(Goods Goods);

    @Delete("DELETE FROM Goods WHERE goods_id = #{goodsId}")
    int deleteGoodsById(Integer goodsId);

    @Select("create TABLE IF NOT EXISTS `goods` ( " +
            " `goods_id` integer(4) NOT NULL AUTO_INCREMENT, " +
            " `goods_name` varchar(45) DEFAULT NULL COMMENT '名称', " +
            " `goods_price` double(10,2) DEFAULT NULL COMMENT '价格', " +
            " `quantity` integer(4) DEFAULT NULL COMMENT '数量', " +
            " `unit` varchar(5) DEFAULT NULL COMMENT '单位', " +
            " `spec` varchar(10) DEFAULT NULL COMMENT '规格', " +
            " `type` varchar(5) DEFAULT NULL, " +
            " `supermarket` varchar(20) DEFAULT NULL COMMENT '超市', " +
            " `record_date` date DEFAULT NULL COMMENT '记录日期', " +
            " `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP, " +
            " `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, " +
            " PRIMARY KEY (`goods_id`) " +
            ") ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;")
    void createGoodsTable();

}
