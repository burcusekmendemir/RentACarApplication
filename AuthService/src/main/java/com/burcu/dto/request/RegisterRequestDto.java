package com.burcu.dto.request;


import com.burcu.utility.enums.ERole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequestDto {

    @NotNull
    private String name;
    @NotNull
    private String surname;

    @Column(unique = true)
    @NotNull
    private String username;

    @Size(min = 8, max = 20)
    @NotNull
    private String password;

    @Column(unique = true)
    @NotNull
    private String tcNo;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private ERole role;



}
