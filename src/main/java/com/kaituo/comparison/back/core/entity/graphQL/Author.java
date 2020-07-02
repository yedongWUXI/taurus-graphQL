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
@ApiModel(value="com.kaituo.comparison.back.core.entity.graphQL.Author")
@Data
@TableName(value = "author")
public class Author {
    public static final String COL_CREATED_TIME = "created_time";
    public static final String COL_UPDATED_TIME = "updated_time";
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_LAST_NAME = "last_name";
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
     * firstName
     */
    @TableField(value = "first_name")
    @ApiModelProperty(value="firstName")
    private String firstName;
    /**
     * lastName
     */
    @TableField(value = "last_name")
    @ApiModelProperty(value="lastName")
    private String lastName;
}