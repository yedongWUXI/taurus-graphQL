package com.kaituo.comparison.back.core.entity.graphQL;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* Created by Mybatis Generator 2020/07/01
*/
@ApiModel(value="com.kaituo.comparison.back.core.entity.graphQL.Book")
@Data
@TableName(value = "book")
public class Book {
    public static final String COL_CREATED_TIME = "created_time";
    public static final String COL_UPDATED_TIME = "updated_time";
    public static final String COL_TITLE = "title";
    public static final String COL_AUTHOR_ID = "author_id";
    public static final String COL_ISBN = "isbn";
    public static final String COL_PAGE_COUNT = "page_count";
    public static final String COL_PRICE = "price";
    /**
     * 主键
     */
     @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Long id;
    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    @ApiModelProperty(value="创建时间")
    private Date createdTime;
    /**
     * 更新时间
     */
    @TableField(value = "updated_time")
    @ApiModelProperty(value="更新时间")
    private Date updatedTime;
    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value="标题")
    private String title;
    @TableField(value = "author_id")
    @ApiModelProperty(value="null")
    private Long authorId;
    @TableField(value = "isbn")
    @ApiModelProperty(value="null")
    private String isbn;
    @TableField(value = "page_count")
    @ApiModelProperty(value="null")
    private Integer pageCount;
    /**
     * 价格
     */
    @TableField(value = "price")
    @ApiModelProperty(value="价格")
    private Double price;
}