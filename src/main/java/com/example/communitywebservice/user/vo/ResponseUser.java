package com.example.communitywebservice.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {

    private String userId;
    private String name;
    private String email;

}
