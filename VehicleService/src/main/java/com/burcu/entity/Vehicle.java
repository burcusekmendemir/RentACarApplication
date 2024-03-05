package com.burcu.entity;

import com.burcu.utility.enums.EColour;
import com.burcu.utility.enums.EStatus;
import com.burcu.utility.enums.EType;
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
    private String year;
    private String description;
    private Double price;
    private EType type;
    private EColour colour;
    @Builder.Default
    private EStatus status=EStatus.NOT_RENTED;

}
