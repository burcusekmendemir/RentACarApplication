package com.burcu.controller;

import com.burcu.dto.request.ActivateAccountRequestDto;
import com.burcu.dto.request.LoginRequestDto;
import com.burcu.dto.request.RegisterRequestDto;
import com.burcu.dto.response.RegisterResponseDto;
import com.burcu.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.burcu.constants.RestApiUrls.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {

    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> doLogin(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authService.doLogin(dto));
    }

    @PostMapping(ACTIVATE_ACCOUNT)
    public ResponseEntity<Boolean> accountActivation(@RequestBody ActivateAccountRequestDto dto){
        return ResponseEntity.ok(authService.accountActivation(dto));
    }
}
