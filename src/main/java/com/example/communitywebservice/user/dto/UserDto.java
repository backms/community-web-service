package com.example.communitywebservice.user.dto;

import lombok.Data;

@Data
public class UserDto {

    private String userId;
    private String name;
    private String email;
    private String pwd;
    private String joinDate;
    private String encryptedPwd;

}
