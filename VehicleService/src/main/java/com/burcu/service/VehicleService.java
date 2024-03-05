package com.burcu.service;

import com.burcu.dto.request.CreateVehicleRequestDto;
import com.burcu.entity.Brand;
import com.burcu.entity.Model;
import com.burcu.entity.Vehicle;
import com.burcu.exception.ErrorType;
import com.burcu.exception.VehicleServiceException;
import com.burcu.mapper.BrandMapper;
import com.burcu.mapper.ModelMapper;
import com.burcu.mapper.VehicleMapper;
import com.burcu.repository.VehicleRepository;
import com.burcu.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class VehicleService extends ServiceManager<Vehicle, String> {
    private final VehicleRepository vehicleRepository;
    private final BrandService brandService;
    private final ModelService modelService;

    public VehicleService(VehicleRepository vehicleRepository, BrandService brandService, ModelService modelService) {
        super(vehicleRepository);
        this.vehicleRepository = vehicleRepository;
        this.brandService = brandService;
        this.modelService = modelService;
    }

    public Vehicle createVehicle(CreateVehicleRequestDto dto) {
        Brand brand=brandService.createBrand(BrandMapper.INSTANCE.fromVehicleDtoToBrandDto(dto));
        Model model= modelService.createModel(ModelMapper.INSTANCE.fromVehicleDtoToModelDto(dto));
        model.setBrandId(brand.getId());

        Optional<Vehicle> vehicleOptional=vehicleRepository.findOptionalByPlate(dto.getPlate());
        if (vehicleOptional.isPresent()){
            throw new VehicleServiceException(ErrorType.PLATE_ALREADY_EXISTS);
        }

        Vehicle vehicle=VehicleMapper.INSTANCE.fromCreateVehicleDtoToVehicle(dto);
        vehicle.setModelId(model.getId());
        return save(vehicle);
    }
}
