package com.burcu.mapper;

import com.burcu.dto.request.CreateUserRequestDto;
import com.burcu.dto.request.RegisterRequestDto;
import com.burcu.dto.response.RegisterResponseDto;
import com.burcu.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapper {

    AuthMapper INSTANCE= Mappers.getMapper(AuthMapper.class);

    Auth fromRegisterRequestDtoToAuth (final RegisterRequestDto dto);

    RegisterResponseDto fromAuthToRegisterResponseDto(final Auth auth);

    CreateUserRequestDto fromAuthToCreateUserRequestDto(final Auth auth);
}
