package com.burcu.repository;

import com.burcu.entity.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BrandRepository extends MongoRepository<Brand, String> {
    Optional<Brand> findByBrandName(String brandName);
}
