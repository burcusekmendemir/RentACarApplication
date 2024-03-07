package com.burcu.mapper;

import com.burcu.dto.request.CreateVehicleRequestDto;
import com.burcu.dto.request.UpdateVehicleRequestDto;
import com.burcu.dto.response.VehicleStatusResponseDto;
import com.burcu.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehicleMapper {

    VehicleMapper INSTANCE= Mappers.getMapper(VehicleMapper.class);

    Vehicle fromCreateVehicleDtoToVehicle(final CreateVehicleRequestDto dto);

    Vehicle fromUpdateVehicleRequestDtoToVehicle(final UpdateVehicleRequestDto dto);

    VehicleStatusResponseDto fromVehicleToVehicleStatusResponseDto(final Vehicle vehicle);
}
