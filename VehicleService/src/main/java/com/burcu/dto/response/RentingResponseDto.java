package com.burcu.dto.response;

import com.burcu.utility.enums.ERentingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RentingResponseDto {

    private String userId;
    private String vehicleId;
    private String startDate;
    private String endDate;
    private ERentingType rentingType;
    private Integer amountOfRenting;
    private Double totalRentingPrice;

}
