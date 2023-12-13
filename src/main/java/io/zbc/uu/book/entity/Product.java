package io.zbc.uu.book.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zbc
 * @date 2023/8/30
 * @see <a href="http://www.xinfadi.com.cn/priceDetail.html"/>
 */
@Data
public class Product {
    private Integer id;
    private String prodName;
    private Integer prodCatid;
    private String prodCat;
    private String prodPcatid;
    private String prodPcat;
    private Double lowPrice;
    private Double highPrice;
    private Double avgPrice;
    private String place;
    private String specInfo;
    private String unitInfo;
    private Date pubDate;
    private String status;
    private Integer userIdCreate;
    private String userIdModified;
    private String userCreate;
    private String userModified;
    private String gmtCreate;
    private String gmtModified;
}
