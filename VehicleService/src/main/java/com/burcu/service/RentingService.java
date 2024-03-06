package com.burcu.service;

import com.burcu.dto.request.CreateRentingRequestDto;
import com.burcu.dto.response.UserResponseDto;
import com.burcu.entity.Renting;
import com.burcu.entity.Vehicle;
import com.burcu.exception.ErrorType;
import com.burcu.exception.VehicleServiceException;
import com.burcu.manager.UserManager;
import com.burcu.repository.RentingRepository;
import com.burcu.repository.VehicleRepository;
import com.burcu.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentingService extends ServiceManager<Renting,String> {
    private final RentingRepository rentingRepository;
    private final VehicleRepository vehicleRepository;

    private final UserManager userManager;
    public RentingService(RentingRepository rentingRepository, VehicleRepository vehicleRepository, UserManager userManager) {
        super(rentingRepository);
        this.rentingRepository = rentingRepository;
        this.vehicleRepository = vehicleRepository;
        this.userManager = userManager;
    }

    //TODO: kiralama kodu yazılmalı, token hatası çözüldü, kod hata vermiyor.
    //TODO: mongoda aynı yerden geçiş yaptır.

    public Boolean rentCar(CreateRentingRequestDto dto) {
        UserResponseDto user = userManager.findByToken(dto.getToken()).getBody();
        if (user == null) {
            throw new VehicleServiceException(ErrorType.USER_NOT_FOUND);
        }

        Optional<Vehicle> vehicleOptional= vehicleRepository.findOptionalById(dto.getVehicleId());
        if (vehicleOptional.isEmpty()){
            throw new VehicleServiceException(ErrorType.VEHICLE_NOT_FOUND);
        }
        return true;
    }
}
