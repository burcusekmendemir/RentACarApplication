package com.burcu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ViewProfileResponseDto {

    private String name;
    private String surname;
    private String username;
    private String address;
    private String email;
    private String about;
    private String avatar;
    private Double balance;
}
