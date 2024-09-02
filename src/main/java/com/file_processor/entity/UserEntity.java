package com.file_processor.entity;

import com.file_processor.enump.AccountStatus;
import com.file_processor.enump.Gender;
import com.file_processor.enump.SubscriptionType;
import jakarta.persistence.*;
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
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String userId;
    private String phoneNumber;
    private Date dateOfBirth;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Enumerated(value = EnumType.STRING)
    private SubscriptionType subscriptionType;
    @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus;
    private OffsetDateTime accountCretionDate;
    private OffsetDateTime accountLastUpdatedDate;

}
