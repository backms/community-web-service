package com.example.communitywebservice.service;

import com.example.communitywebservice.dto.UserDto;
import com.example.communitywebservice.jpa.UserEntity;

public interface UserService {
    UserDto userRegister(UserDto userDto);

    Iterable<UserEntity> getUserByAll();
    UserDto getUserByUserId(String userId);
}
