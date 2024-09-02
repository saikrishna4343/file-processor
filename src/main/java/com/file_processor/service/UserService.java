package com.file_processor.service;

import com.file_processor.domain.UserVO;
import com.file_processor.entity.UserEntity;
import com.file_processor.repository.UserRepository;
import com.file_processor.utils.UserUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;
    UserUtils userUtils;

    public UserVO saveUser(UserVO userVO){
        userVO.setUserId(userUtils.generateUserId(userVO.getFirstName(), userVO.getLastName()));
        UserEntity userEntity = UserEntity.builder()
                .userId(userVO.getUserId())
                .email(userVO.getEmail())
                .firstName(userVO.getFirstName())
                .lastName(userVO.getLastName())
                .build();
        userRepository.save(userEntity);
        return userVO;
    }
}
