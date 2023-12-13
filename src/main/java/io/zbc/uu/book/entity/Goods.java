package io.zbc.uu.book.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Goods {

    private Integer goodsId;
    private String goodsName;
    private Double goodsPrice;
    private Integer quantity;
    private String unit;
    private String spec;
    private String type;
    private String supermarket;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date recordDate;

}
