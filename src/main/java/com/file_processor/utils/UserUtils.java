package com.file_processor.utils;

import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    public String generateUserId(String firstName, String lastName){
         return firstName.split(" ")[0]+"." + lastName;
    }

}
