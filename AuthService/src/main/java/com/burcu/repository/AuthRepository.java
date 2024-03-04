package com.burcu.repository;

import com.burcu.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth,Long> {
    Optional<Auth> findByUsernameAndPassword(String username, String password);
}
