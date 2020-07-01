package com.kaituo.comparison.back.core.controller;

import com.kaituo.comparison.back.common.bean.ResponseCode;
import com.kaituo.comparison.back.common.bean.ResponseResult;
import com.kaituo.comparison.back.core.mapper.shop.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2020/2/13 17:14
 * @Modified by:
 */
@RestController
@RequestMapping(value = {"/common"})
public class CommonControl {

    @Autowired
    ShopMapper shopMapper;

    @GetMapping(value = "/cors")
    public String cors() {
        return "cors success";
    }
    @GetMapping(value = "/test")
    public ResponseResult test() {

        List<Map<String, Object>> maps = shopMapper.selectAll();

        return ResponseResult.e(ResponseCode.OK,maps);
    }
}
