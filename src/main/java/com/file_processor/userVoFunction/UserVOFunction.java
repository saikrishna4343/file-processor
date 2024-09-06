package com.file_processor.userVoFunction;

import com.file_processor.domain.UserVO;
import com.file_processor.entity.UserEntity;

import java.util.function.Function;

public class UserVOFunction {

    public static Function<UserVO, UserEntity> toEntity = userVO -> UserEntity.builder()
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

    public static Function<UserEntity, UserVO> toUserVO = userEntity -> UserVO.builder()
            .userId(userEntity.getUserId())
            .email(userEntity.getEmail())
            .firstName(userEntity.getFirstName())
            .lastName(userEntity.getLastName())
            .phoneNumber(userEntity.getPhoneNumber())
            .dateOfBirth(userEntity.getDateOfBirth())
            .gender(userEntity.getGender())
            .subscriptionType(userEntity.getSubscriptionType())
            .accountStatus(userEntity.getAccountStatus())
            .accountCretionDate(userEntity.getAccountCretionDate())
            .accountLastUpdatedDate(userEntity.getAccountLastUpdatedDate())
            .build();
}
