package com.file_processor.service;

import com.file_processor.domain.UserVO;
import com.file_processor.entity.UserEntity;
import com.file_processor.enump.AccountStatus;
import com.file_processor.repository.UserRepository;
import com.file_processor.utils.UserUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;
    UserUtils userUtils;

    public UserVO saveUser(UserVO userVO){
        userVO.setUserId(userUtils.generateUserId(userVO.getFirstName(), userVO.getLastName()));
        userVO.setAccountStatus(AccountStatus.Active);
        userVO.setAccountCretionDate(OffsetDateTime.now());
        userVO.setAccountLastUpdatedDate(OffsetDateTime.now());
        UserEntity userEntity = UserEntity.builder()
                .userId(userVO.getUserId())
                .email(userVO.getEmail())
                .firstName(userVO.getFirstName())
                .lastName(userVO.getLastName())
                .phoneNumber(userVO.getPhoneNumber())
                .dateOfBirth(userVO.getDateOfBirth())
                .gender(userVO.getGender())
                .subscriptionType(userVO.getSubscriptionType())
                .accountStatus(userVO.getAccountStatus())
                .accountCretionDate(userVO.getAccountCretionDate())
                .accountLastUpdatedDate(userVO.getAccountLastUpdatedDate())
                .build();
        userRepository.save(userEntity);
        return userVO;
    }
}
