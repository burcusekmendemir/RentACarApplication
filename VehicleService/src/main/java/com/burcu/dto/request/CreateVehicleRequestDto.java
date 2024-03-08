package com.burcu.dto.request;

import com.burcu.utility.enums.EColour;
import com.burcu.utility.enums.ERole;
import com.burcu.utility.enums.EVehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateVehicleRequestDto {

    private String token;
    private String plate;
    private String brandName;
    private String modelName;
    private EVehicleType type;
    private String year;
    private String description;
    private EColour colour;
    private Double kilometer;
    private Double amountOfFuel;
    private Double hourlyPrice;
    private Double dailyPrice;
    private Double weeklyPrice;


}
