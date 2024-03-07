package com.burcu.dto.response;

import com.burcu.utility.enums.EVehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class VehicleStatusResponseDto {

    private String id;
    //private String token; // yoksa long authId mi?
    private String plate;
    private EVehicleStatus status;
}
