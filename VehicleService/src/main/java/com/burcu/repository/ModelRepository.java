package com.burcu.repository;

import com.burcu.entity.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ModelRepository extends MongoRepository<Model, String> {
    Optional<Model> findByModelName(String modelName);
}
