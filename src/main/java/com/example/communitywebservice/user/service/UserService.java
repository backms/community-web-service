package com.example.communitywebservice.user.service;

import com.example.communitywebservice.user.dto.UserDto;
import com.example.communitywebservice.user.jpa.UserEntity;

public interface UserService {
    UserDto userRegister(UserDto userDto);

    Iterable<UserEntity> getUserByAll();
    UserDto getUserByUserId(String userId);
}
