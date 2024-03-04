package com.burcu.entity;

import com.burcu.utility.enums.ERole;
import com.burcu.utility.enums.EStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Column(unique = true)
    private String username;

    // TODO : kısıtlamalar dtoda belirtilecek
    @Size(min = 8, max = 20)
    @NotNull
    private String password;
    private String tcNo;
    private String email;
    private String phoneNumber;
    private String address;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ERole role=ERole.USER;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status=EStatus.PENDING;

    private String activationCode;


}
