package com.burcu.dto.request;

import com.burcu.utility.enums.EColour;
import com.burcu.utility.enums.EVehicleStatus;
import com.burcu.utility.enums.EVehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdateVehicleRequestDto {

    private String id;
    private String token;
    private String plate;
    private String modelId;
    private EVehicleType type;
    private String year;
    private EColour colour;
    private String description;
    private Double amountOfFuel;
    private Double kilometer;
    private Double hourlyPrice;
    private Double dailyPrice;
    private Double weeklyPrice;
    private EVehicleStatus status;
}
