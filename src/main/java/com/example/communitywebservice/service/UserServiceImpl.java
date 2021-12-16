package com.example.communitywebservice.service;

import com.example.communitywebservice.dto.UserDto;
import com.example.communitywebservice.jpa.UserEntity;
import com.example.communitywebservice.jpa.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto userRegister(UserDto userDto) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPwd(bCryptPasswordEncoder.encode(userDto.getPwd()));

        userRepository.save(userEntity);

        UserDto joinInfo = mapper.map(userEntity, UserDto.class);

        return joinInfo;
    }

    @Override
    public Iterable<UserEntity> getUserByAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDto getUserById(String id) {

        UserEntity userEntity = userRepository.findById(id);

        if(userEntity == null) {
            throw new UsernameNotFoundException("User Not Found");
        }

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

        return userDto;
    }
}
