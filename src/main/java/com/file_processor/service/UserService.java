package com.file_processor.service;

import com.file_processor.domain.UserVO;
import com.file_processor.entity.UserEntity;
import com.file_processor.enump.AccountStatus;
import com.file_processor.repository.UserRepository;
import com.file_processor.userVoFunction.UserVOFunction;
import com.file_processor.utils.UserUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
//        UserEntity userEntity = UserEntity.builder()
//                .userId(userVO.getUserId())
//                .email(userVO.getEmail())
//                .firstName(userVO.getFirstName())
//                .lastName(userVO.getLastName())
//                .phoneNumber(userVO.getPhoneNumber())
//                .dateOfBirth(userVO.getDateOfBirth())
//                .gender(userVO.getGender())
//                .subscriptionType(userVO.getSubscriptionType())
//                .accountStatus(userVO.getAccountStatus())
//                .accountCretionDate(userVO.getAccountCretionDate())
//                .accountLastUpdatedDate(userVO.getAccountLastUpdatedDate())
//                .build();
            UserEntity userEntity = UserVOFunction.toEntity.apply(userVO);
        userRepository.save(userEntity);
        return userVO;
    }
    public List<UserVO> addingMultipleUsers(List<UserVO> userVOList){

            List<UserEntity> userEntityList = userVOList.stream().map(userVO -> {
                userVO.setUserId(userUtils.generateUserId(userVO.getFirstName(), userVO.getLastName()));
                userVO.setAccountStatus(AccountStatus.Active);
                userVO.setAccountCretionDate(OffsetDateTime.now());
                userVO.setAccountLastUpdatedDate(OffsetDateTime.now());
//                        return UserEntity.builder()
//                                .userId(userVO.getUserId())
//                                .email(userVO.getEmail())
//                                .firstName(userVO.getFirstName())
//                                .lastName(userVO.getLastName())
//                                .phoneNumber(userVO.getPhoneNumber())
//                                .dateOfBirth(userVO.getDateOfBirth())
//                                .gender(userVO.getGender())
//                                .subscriptionType(userVO.getSubscriptionType())
//                                .accountStatus(userVO.getAccountStatus())
//                                .accountCretionDate(userVO.getAccountCretionDate())
//                                .accountLastUpdatedDate(userVO.getAccountLastUpdatedDate())
//                                .build();
                            return UserVOFunction.toEntity.apply(userVO);
            }).collect(Collectors.toList());
        userRepository.saveAll(userEntityList);
            return userVOList;
    }

    public UserVO getUserDetails(String userId) {
        if ((userId != null)) {            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity != null) {
//                return UserVO.builder()
//                        .userId(userEntity.getUserId())
//                        .email(userEntity.getEmail())
//                        .firstName(userEntity.getFirstName())
//                        .lastName(userEntity.getLastName())
//                        .phoneNumber(userEntity.getPhoneNumber())
//                        .dateOfBirth(userEntity.getDateOfBirth())
//                        .gender(userEntity.getGender())
//                        .subscriptionType(userEntity.getSubscriptionType())
//                        .accountStatus(userEntity.getAccountStatus())
//                        .accountCretionDate(userEntity.getAccountCretionDate())
//                        .accountLastUpdatedDate(userEntity.getAccountLastUpdatedDate())
//                        .build();
                    return UserVOFunction.toUserVO.apply(userEntity);
            }else throw new RuntimeException("user not found");
        } else return null;
    }

    public UserVO updateUserDetails(String userId, UserVO userVO) {
        if (userId != null) {
            UserEntity userEntity = userRepository.findByUserId(userId);
            if (userEntity != null) {
                if(userVO.getEmail() != null){
                    userEntity.setEmail(userVO.getEmail());
                }
                if(userVO.getPhoneNumber() != null){
                    userEntity.setPhoneNumber(userVO.getPhoneNumber());
                }
                if(userVO.getDateOfBirth() !=null){
                    userEntity.setPhoneNumber(userVO.getPhoneNumber());
                }
                if(userVO.getFirstName() != null){
                    userEntity.setFirstName(userVO.getFirstName());
                }
                if(userVO.getLastName() != null){
                    userEntity.setLastName(userVO.getLastName());
                }
                if(userVO.getSubscriptionType() !=null){
                    userEntity.setSubscriptionType(userVO.getSubscriptionType());
                }
                if(userVO.getUserId() != null){
                    userEntity.setUserId(userVO.getUserId());
                }
                if(userVO.getGender() != null){
                    userEntity.setGender(userVO.getGender());
                }
                if(userVO.getAccountStatus() !=null){
                    userEntity.setAccountStatus(userVO.getAccountStatus());
                }
               userEntity.setAccountLastUpdatedDate(OffsetDateTime.now());
                userRepository.save(userEntity);

//                return UserVO.builder()
//                        .userId(userEntity.getUserId())
//                        .email(userEntity.getEmail())
//                        .firstName(userEntity.getFirstName())
//                        .lastName(userEntity.getLastName())
//                        .phoneNumber(userEntity.getPhoneNumber())
//                        .dateOfBirth(userEntity.getDateOfBirth())
//                        .gender(userEntity.getGender())
//                        .subscriptionType(userEntity.getSubscriptionType())
//                        .accountStatus(userEntity.getAccountStatus())
//                        .accountCretionDate(userEntity.getAccountCretionDate())
//                        .accountLastUpdatedDate(userEntity.getAccountLastUpdatedDate())
//                        .build();
                    return UserVOFunction.toUserVO.apply(userEntity);

            }else throw new RuntimeException("User Not Found");
        }else return null;
    }

    public UserVO deActivateUserAccount(String userId){
        if(userId != null){
                UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity != null){
                userEntity.setAccountStatus(AccountStatus.Deactive);
                userEntity.setAccountLastUpdatedDate(OffsetDateTime.now());
                userRepository.save(userEntity);
//                return UserVO.builder()
//                        .userId(userEntity.getUserId())
//                        .email(userEntity.getEmail())
//                        .firstName(userEntity.getFirstName())
//                        .lastName(userEntity.getLastName())
//                        .phoneNumber(userEntity.getPhoneNumber())
//                        .dateOfBirth(userEntity.getDateOfBirth())
//                        .gender(userEntity.getGender())
//                        .subscriptionType(userEntity.getSubscriptionType())
//                        .accountStatus(userEntity.getAccountStatus())
//                        .accountCretionDate(userEntity.getAccountCretionDate())
//                        .accountLastUpdatedDate(userEntity.getAccountLastUpdatedDate())
//                        .build();
                return UserVOFunction.toUserVO.apply(userEntity);
            }else throw new RuntimeException("User not Found");
        }else return null;
    }

}
