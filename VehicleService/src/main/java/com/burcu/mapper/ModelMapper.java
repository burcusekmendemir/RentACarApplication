package com.burcu.mapper;

import com.burcu.dto.request.CreateBrandRequestDto;
import com.burcu.dto.request.CreateModelRequestDto;
import com.burcu.dto.request.CreateVehicleRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ModelMapper {

    ModelMapper INSTANCE= Mappers.getMapper(ModelMapper.class);

    CreateModelRequestDto fromVehicleDtoToModelDto(final CreateVehicleRequestDto dto);
}
