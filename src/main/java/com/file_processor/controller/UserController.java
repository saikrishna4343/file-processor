package com.file_processor.controller;

import com.file_processor.domain.UserVO;
import com.file_processor.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
