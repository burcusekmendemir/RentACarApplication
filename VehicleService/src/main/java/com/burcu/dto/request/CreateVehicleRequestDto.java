package com.burcu.dto.request;

import com.burcu.utility.enums.EColour;
import com.burcu.utility.enums.EType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateVehicleRequestDto {

    private String plate;
    private String brandName;
    private String modelName;
    private EType type;
    private String year;
    private String description;
    private Double price;
    private EColour colour;

}
