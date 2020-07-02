package com.kaituo.comparison.back.core.dto.model;

import lombok.Data;

/**
 * AuthData.java
 *
 * @author yedong
 * @create 2019-03-02 11:16
 */
@Data
public class AuthData {

    private String pwd;
    private Long id;
    private String email;
}
