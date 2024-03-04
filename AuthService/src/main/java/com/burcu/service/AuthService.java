package com.burcu.service;

import com.burcu.dto.request.LoginRequestDto;
import com.burcu.dto.request.RegisterRequestDto;
import com.burcu.dto.response.RegisterResponseDto;
import com.burcu.entity.Auth;
import com.burcu.mapper.AuthMapper;
import com.burcu.repository.AuthRepository;
import com.burcu.utility.CodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    /**
     * Kullanıcının kayıt işleminin yapılmasını sağlar.
     * @param dto
     * @return
     */
    public RegisterResponseDto register(RegisterRequestDto dto) {
        Auth auth= AuthMapper.INSTANCE.fromRegisterRequestDtoToAuth(dto);
        auth.setActivationCode(CodeGenerator.createActivationCode());
        authRepository.save(auth);

        return AuthMapper.INSTANCE.fromAuthToRegisterResponseDto(auth);
    }


    public Boolean doLogin(LoginRequestDto dto) {
        return true;

    }
}
