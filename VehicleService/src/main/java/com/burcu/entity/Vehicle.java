package com.burcu.entity;

import com.burcu.utility.enums.EColour;
import com.burcu.utility.enums.EVehicleStatus;
import com.burcu.utility.enums.EVehicleType;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Vehicle extends BaseEntity{

    @Id
    private String id;
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




    @Builder.Default
    private EVehicleStatus status= EVehicleStatus.NOT_RENTED;


}
