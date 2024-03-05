package com.burcu.entity;

import com.burcu.utility.enums.ERentingStatus;
import com.burcu.utility.enums.ERentingType;
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
public class Renting extends BaseEntity {

    @Id
    private String id;
    private String userId;
    private String vehicleId;
    private String startDate;
    private String endDate;
    private ERentingType rentingType;
    private Integer amountOfRenting;
    private Double totalRentingPrice;

    @Builder.Default
    private ERentingStatus rentingStatus=ERentingStatus.ACTIVE;

}
