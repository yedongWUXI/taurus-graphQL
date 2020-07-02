package com.kaituo.comparison.back.core.entity.graphQL;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* Created by Mybatis Generator 2020/07/01
*/
@ApiModel(value="com.kaituo.comparison.back.core.entity.graphQL.User")
@Data
@TableName(value = "user")
public class User {
    public static final String COL_NAME = "name";
    public static final String COL_AGE = "age";
    public static final String COL_BALANCE = "balance";
    public static final String COL_EMAIL = "email";
    public static final String COL_PWD = "pwd";
     @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="null")
    private Long id;
    @TableField(value = "name")
    @ApiModelProperty(value="null")
    private String name;
    @TableField(value = "age")
    @ApiModelProperty(value="null")
    private Short age;
    @TableField(value = "balance")
    @ApiModelProperty(value="null")
    private Long balance;
    @TableField(value = "email")
    @ApiModelProperty(value="null")
    private String email;
    @TableField(value = "pwd")
    @ApiModelProperty(value="null")
    private String pwd;
}