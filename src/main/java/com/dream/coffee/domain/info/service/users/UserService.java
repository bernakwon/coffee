package com.dream.coffee.domain.info.service.users;

import com.dream.coffee.domain.info.dto.UserResponse;
import com.dream.coffee.domain.info.entity.Users;

import java.util.List;

public interface UserService{
    List<UserResponse> getAllUsers();
}
