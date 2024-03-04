package com.burcu.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUserRequestDto {

    private Long authId;
    private String name;
    private String surname;
    @Email
    private String email;
    private String phoneNumber;
    private String address;
    private String about;
    private String avatar;
}
