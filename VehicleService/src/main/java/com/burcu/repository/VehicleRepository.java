package com.burcu.repository;

import com.burcu.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    Optional<Vehicle> findOptionalByPlate(String plate);

    Optional<Vehicle> findOptionalById(String vehicleId);


}
