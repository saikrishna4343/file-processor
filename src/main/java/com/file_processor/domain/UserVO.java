package com.file_processor.domain;

import com.file_processor.enump.AccountStatus;
import com.file_processor.enump.Gender;
import com.file_processor.enump.SubscriptionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
    private String phoneNumber;
    private Date dateOfBirth;
    private Gender gender;
    private SubscriptionType subscriptionType;
    private AccountStatus accountStatus;
    private OffsetDateTime accountCretionDate;
    private OffsetDateTime accountLastUpdatedDate;
}
