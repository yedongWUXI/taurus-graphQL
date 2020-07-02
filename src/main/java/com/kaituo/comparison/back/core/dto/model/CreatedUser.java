package com.kaituo.comparison.back.core.dto.model;

import com.kaituo.comparison.back.core.entity.graphQL.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CreatedUser.java
 *
 * @author yedong
 * @create 2019-03-02 11:14
 */
@Data
@AllArgsConstructor
public class CreatedUser implements CreateUserResult {
    private User user;
}
