package com.burcu.mapper;

import com.burcu.dto.request.CreateUserRequestDto;
import com.burcu.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    User fromCreateUserRequestDtoToUser(final CreateUserRequestDto dto);

}
