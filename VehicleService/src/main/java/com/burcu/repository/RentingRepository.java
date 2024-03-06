package com.burcu.repository;

import com.burcu.entity.Renting;
import com.burcu.utility.enums.ERentingType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RentingRepository extends MongoRepository<Renting, String> {
    Optional<String> findOptionalByUserId(String userId);

    List<Renting> findByVehicleIdAndStartDateAndEndDateAndRentingTypeAndAmountOfRenting(
            String vehicleId, String startDate, String endDate, ERentingType rentingType, Integer amountOfRenting);
}
