package com.example.communitywebservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestUser {

    @NotNull
    @Size(min=6)
    private String userId;

    @NotNull
    @Size(min=6)
    private String name;

    @NotNull(message = "Please Write E-Mail")
    @Size(min=2)
    @Email
    private String email;

    @NotNull
    @Size(min=8)
    private String pwd;

}
