package com.kaituo.comparison.back.core.dto.model;

import lombok.Data;

/**
 * 为演示GraphQL interface创建的实现实体
 *
 * @author yedong
 * @create 2019-02-20 17:29
 */
@Data
public class Fish implements Animal {
    private String tailColor;
    private String name;

}
