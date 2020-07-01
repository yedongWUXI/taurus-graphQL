package com.kaituo.comparison.back.core.mapper.shop;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaituo.comparison.back.core.entity.shop.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* Created by Mybatis Generator 2020/04/01
*/
@Mapper
public interface ShopMapper extends BaseMapper<Shop> {

    List<Map<String,Object>> selectAll();
}