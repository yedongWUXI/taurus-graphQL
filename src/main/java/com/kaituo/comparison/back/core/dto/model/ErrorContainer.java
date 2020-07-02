package com.kaituo.comparison.back.core.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * ErrorContainer.java
 *
 * @author yedong
 * @create 2019-03-02 11:15
 */
@Data
@AllArgsConstructor
public class ErrorContainer implements CreateUserResult,LoginResult {
    private List<String> messages;
}
