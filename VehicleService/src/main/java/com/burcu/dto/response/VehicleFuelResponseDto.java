package com.burcu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class VehicleFuelResponseDto {


    private String id;
    private String plate;
    private Double amountOfFuel;
}
