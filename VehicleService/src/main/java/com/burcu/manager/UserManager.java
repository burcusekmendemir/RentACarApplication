package com.burcu.manager;

import com.burcu.dto.response.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.burcu.constants.RestApiUrls.*;

@FeignClient(name = "renting-user", url = "http://localhost:8081/dev/v1/user")
public interface UserManager {

    @GetMapping(FIND_BY_TOKEN)
    ResponseEntity<UserResponseDto> findByToken(@RequestParam String token);
}
