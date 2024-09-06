package com.file_processor.controller;

import com.file_processor.domain.UserVO;
import com.file_processor.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/user")
@Slf4j
@AllArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO addNewUser(@RequestBody UserVO userVO){
        return userService.saveUser(userVO);
    }

    @PostMapping(path = "/add/multiple")
    public List<UserVO> addListOfUsers(@RequestBody List<UserVO> userVOList){
        return userService.addingMultipleUsers(userVOList);

    }

    @GetMapping(path = "/get-details")
    public UserVO getUserDetails(@RequestParam(name = "userId") String userId) {
            return userService.getUserDetails(userId);
    }

    @PutMapping(path = "/update-details")
    public UserVO updateUserDetails(@RequestParam(name = "userId") String userId, @RequestBody UserVO userVO){
        return userService.updateUserDetails(userId,userVO);
    }

    @PutMapping(path = "/deactivate-user")
    public UserVO deActivateAccount(@RequestParam(name = "userId") String userId){
        return userService.deActivateUserAccount(userId);
    }


}
