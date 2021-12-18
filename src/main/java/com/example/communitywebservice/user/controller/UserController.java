package com.example.communitywebservice.user.controller;

import com.example.communitywebservice.user.dto.UserDto;
import com.example.communitywebservice.user.jpa.UserEntity;
import com.example.communitywebservice.user.service.UserService;
import com.example.communitywebservice.user.vo.RequestUser;
import com.example.communitywebservice.user.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in Communnity Web Service";
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> userRegister(@RequestBody RequestUser requestUser){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(requestUser, UserDto.class);
        userService.userRegister(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUser() {

        Iterable<UserEntity> userList = userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();
        userList.forEach( v -> {
            result.add(new ModelMapper().map(v, ResponseUser.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUserById(@PathVariable String userId){

        UserDto userDto = userService.getUserByUserId(userId);

        ResponseUser responseUser = new ModelMapper().map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }

}
