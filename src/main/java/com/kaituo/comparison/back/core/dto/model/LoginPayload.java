package com.kaituo.comparison.back.core.dto.model;

import com.kaituo.comparison.back.core.entity.graphQL.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yedong
 * @create 2019-03-02 16:00
 */
@Data
@AllArgsConstructor
public class LoginPayload implements LoginResult{
    private Long token;
    private User user;
}
