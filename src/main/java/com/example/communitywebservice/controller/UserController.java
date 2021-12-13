package com.example.communitywebservice.controller;

import com.example.communitywebservice.dto.UserDto;
import com.example.communitywebservice.service.UserService;
import com.example.communitywebservice.vo.RequestUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in Communnity Web Service";
    }

    @PostMapping("/users")
    public String userRegister(@RequestBody RequestUser requestUser){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(requestUser, UserDto.class);
        userService.userRegister(userDto);

        return "User Register Success";
    }

}
