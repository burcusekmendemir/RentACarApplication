package com.burcu.service;

import com.burcu.dto.request.CreateRentingRequestDto;
import com.burcu.dto.response.RentingResponseDto;
import com.burcu.entity.Renting;
import com.burcu.entity.Vehicle;
import com.burcu.exception.ErrorType;
import com.burcu.exception.VehicleServiceException;
import com.burcu.mapper.RentingMapper;
import com.burcu.repository.RentingRepository;
import com.burcu.repository.VehicleRepository;
import com.burcu.utility.JwtTokenManager;
import com.burcu.utility.ServiceManager;
import com.burcu.utility.enums.EVehicleStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentingService extends ServiceManager<Renting,String> {
    private final RentingRepository rentingRepository;
    private final VehicleRepository vehicleRepository;
    private final JwtTokenManager jwtTokenManager;


    public RentingService(RentingRepository rentingRepository, VehicleRepository vehicleRepository, JwtTokenManager jwtTokenManager) {
        super(rentingRepository);
        this.rentingRepository = rentingRepository;
        this.vehicleRepository = vehicleRepository;
        this.jwtTokenManager = jwtTokenManager;

    }

    // TODO: kiralama kodu yazılmalı.
    // TODO: token ile kiralama yapılmalı ve role olarak USER kullanılmalı.

    public RentingResponseDto rentCar(CreateRentingRequestDto dto) {
        Optional<Long> authId= jwtTokenManager.getIdFromToken(dto.getToken());
        if (authId.isEmpty()){
            throw new VehicleServiceException(ErrorType.USER_NOT_FOUND);
        }

        Optional<String> userRole=jwtTokenManager.getRoleFromToken(dto.getToken());
        if (!userRole.isPresent() || !userRole.get().equals("USER")) {
            throw new VehicleServiceException(ErrorType.UNAUTHORIZED);
        }

        Optional<Vehicle> vehicleOptional= vehicleRepository.findById(dto.getVehicleId());
        if (vehicleOptional.isEmpty()){
            throw new VehicleServiceException(ErrorType.VEHICLE_NOT_FOUND);
        }

        Vehicle vehicle=vehicleOptional.get();
        if (vehicle.getStatus().equals(EVehicleStatus.RENTED)){
            throw new VehicleServiceException(ErrorType.RENTING_IS_ALREADY_EXISTS);
        }

        vehicle.setStatus(EVehicleStatus.RENTED);
        vehicleRepository.save(vehicle);

        return RentingMapper.INSTANCE.fromRentingRequestToRentingResponce(dto);
    }
}
