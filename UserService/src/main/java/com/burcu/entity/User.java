package com.burcu.entity;

import com.burcu.utility.enums.ERole;
import com.burcu.utility.enums.EStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User extends BaseEntity {

    @Id
    private String id;
    private Long authId;
    private String name;
    private String surname;
    private String username;
    private String tcNo;
    private String email;
    private String phoneNumber;
    private String address;
    private String about;
    private String avatar;
    private Double balance;
    private ERole role;
    @Builder.Default
    private List<String> rentingList=new ArrayList<>();

    @Builder.Default
    EStatus status=EStatus.PENDING;





}
