package com.burcu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdatePriceRequestDto {

    private String id;
    private String token;
    private Double hourlyPrice;
    private Double dailyPrice;
    private Double weeklyPrice;
}
