package com.burcu.mapper;

import com.burcu.dto.request.CreateRentingRequestDto;
import com.burcu.dto.response.RentingResponseDto;
import com.burcu.entity.Renting;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RentingMapper {

    RentingMapper INSTANCE= Mappers.getMapper(RentingMapper.class);

    RentingResponseDto fromRentingRequestToRentingResponce (final CreateRentingRequestDto dto);

}
