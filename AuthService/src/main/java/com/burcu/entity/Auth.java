package com.burcu.entity;

import com.burcu.utility.enums.ERole;
import com.burcu.utility.enums.EStatus;
import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Auth extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String tcNo;
    private String email;
    private String phoneNumber;
    private String address;
    private Double balance;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.PENDING;

    private String activationCode;


}
