package com.burcu.dto.request;

import com.burcu.utility.enums.ERole;
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

public class CreateUserRequestDto {

    private Long authId;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String username;
    @Size(min = 11, max = 11)
    private String tcNo;
    @NotNull
    @Email
    private String email;
    private ERole role;
}
