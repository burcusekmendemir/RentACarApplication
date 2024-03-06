package com.burcu.dto.response;

import com.burcu.utility.enums.EStatus;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserResponseDto {

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

    @Builder.Default
    private List<String> rentingList=new ArrayList<>();

    @Builder.Default
    EStatus status=EStatus.PENDING;
}
