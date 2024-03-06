package com.burcu.manager;

import com.burcu.dto.request.CreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.burcu.constants.RestApiUrls.*;

@FeignClient(url = "http://localhost:8081/dev/v1/user", name = "user-manager")
public interface UserManager {

    @PostMapping(CREATE_USER)
    ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto);

    @GetMapping(ACTIVATE_USER+"/{authId}")
    ResponseEntity<Boolean> activateUser(@PathVariable Long authId);
}
