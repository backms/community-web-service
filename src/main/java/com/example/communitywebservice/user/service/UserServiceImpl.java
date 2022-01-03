package com.example.communitywebservice.user.service;

import com.example.communitywebservice.user.dto.UserDto;
import com.example.communitywebservice.user.jpa.UserEntity;
import com.example.communitywebservice.user.jpa.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto userRegister(UserDto userDto) {

        userDto.setUserNo(UUID.randomUUID().toString());
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
    public UserDto getUserByUserId(String userId) {

        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null) {
            throw new UsernameNotFoundException("User Not Found");
        }

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

        return userDto;
    }

    @Override
    public UserDto editUserByUserId(UserDto userDto) {

        UserEntity userEntity = new ModelMapper().map(userDto, UserEntity.class);
        userRepository.save(userEntity);

        UserDto resultValue = new ModelMapper().map(userEntity, UserDto.class);

        return resultValue;
    }

    @Override
    public void deleteByUserId(String userId) {
        userRepository.deleteByUserId(userId);
    }


}
