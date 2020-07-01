package com.kaituo.comparison.back.core.entity.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import lombok.Data;

/**
 * Created by Mybatis Generator 2020/04/01
 */
@ApiModel(value = "com.kaituo.comparison.back.core.entity.shop.Shop")
@Data
@TableName(value = "shop")
public class Shop {
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "null")
    private String id;

    @TableField(value = "shopname")
    @ApiModelProperty(value = "null")
    private String shopname;

    @TableField(value = "count")
    @ApiModelProperty(value = "null")
    private Integer count;

    @TableField(value = "createDate")
    @ApiModelProperty(value = "null")
    private Date createdate;

    @TableField(value = "updateDate")
    @ApiModelProperty(value = "null")
    private Date updatedate;

    public static final String COL_SHOPNAME = "shopname";

    public static final String COL_COUNT = "count";

    public static final String COL_CREATEDATE = "createDate";

    public static final String COL_UPDATEDATE = "updateDate";
}