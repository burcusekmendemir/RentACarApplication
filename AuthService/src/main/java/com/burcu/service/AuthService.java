package com.burcu.service;

import com.burcu.dto.request.ActivateAccountRequestDto;
import com.burcu.dto.request.LoginRequestDto;
import com.burcu.dto.request.RegisterRequestDto;
import com.burcu.dto.response.RegisterResponseDto;
import com.burcu.entity.Auth;
import com.burcu.exception.AuthServiceException;
import com.burcu.exception.ErrorType;
import com.burcu.mapper.AuthMapper;
import com.burcu.repository.AuthRepository;
import com.burcu.utility.CodeGenerator;
import com.burcu.utility.ServiceManager;
import com.burcu.utility.enums.EStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AuthService extends ServiceManager<Auth,Long> {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        super(authRepository);
        this.authRepository=authRepository;
    }

    /**
     * Kullanıcının uygulamaya üye olmasını sağlar.
     * @param dto
     * @return
     */
    public RegisterResponseDto register(RegisterRequestDto dto) {
        Auth auth= AuthMapper.INSTANCE.fromRegisterRequestDtoToAuth(dto);
        auth.setActivationCode(CodeGenerator.createActivationCode());
        save(auth);

        return AuthMapper.INSTANCE.fromAuthToRegisterResponseDto(auth);
    }


    /**
     * Kullanıcının Username ve password ile giriş yapabilmesini sağlar.
     * // TODO : token login sırasında yaratılmalı.
     * @param dto
     * @return
     */
    public Boolean doLogin(LoginRequestDto dto) {
        Optional<Auth> optionalAuth= authRepository.findByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if (optionalAuth.isEmpty()){
            throw new AuthServiceException(ErrorType.LOGIN_ERROR);
        }
//        if (optionalAuth.get().getStatus().equals(EStatus.ACTIVE)){
//
//        }

        return true;

    }

    /**
     * AuthId ve activationCode ile kullanıcının hesabının aktifleştirilmesini sağlar.
     * @param dto
     * @return
     */

    public Boolean accountActivation(ActivateAccountRequestDto dto) {
        Optional<Auth> authOptional= authRepository.findById(dto.getAuthId());
        if (authOptional.isEmpty()){
            throw new AuthServiceException(ErrorType.USER_NOT_FOUND);
        }

        if (authOptional.get().getActivationCode().equals(dto.getActivationCode())){
            authOptional.get().setStatus(EStatus.ACTIVE);
            update(authOptional.get());
            return true;
        }else {
            throw new AuthServiceException(ErrorType.ACTIVATION_CODE_ERROR);
        }
    }
}
