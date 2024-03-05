package com.burcu.repository;

import com.burcu.entity.Renting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentingRepository extends MongoRepository<Renting, String> {
}
