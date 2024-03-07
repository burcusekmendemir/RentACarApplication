package com.burcu.mapper;

import com.burcu.dto.request.CreateRentingRequestDto;
import com.burcu.dto.request.CreateUserRequestDto;
import com.burcu.dto.response.BalanceResponseDto;
import com.burcu.dto.response.UserResponseDto;
import com.burcu.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    User fromCreateUserRequestDtoToUser(final CreateUserRequestDto dto);

    CreateRentingRequestDto fromUserToCreateRentingRequestDto(final User user);

    UserResponseDto fromUserToUserResponseDto(final User user);

    BalanceResponseDto fromUserToBalanceResponseDto(final User user);
}
