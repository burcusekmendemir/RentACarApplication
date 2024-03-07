package com.burcu.service;

import com.burcu.dto.request.CreateVehicleRequestDto;
import com.burcu.dto.request.UpdateVehicleRequestDto;
import com.burcu.entity.Brand;
import com.burcu.entity.Model;
import com.burcu.entity.Vehicle;
import com.burcu.exception.ErrorType;
import com.burcu.exception.VehicleServiceException;
import com.burcu.mapper.BrandMapper;
import com.burcu.mapper.ModelMapper;
import com.burcu.mapper.VehicleMapper;
import com.burcu.repository.VehicleRepository;
import com.burcu.utility.JwtTokenManager;
import com.burcu.utility.ServiceManager;
import com.burcu.utility.enums.EVehicleStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class VehicleService extends ServiceManager<Vehicle, String> {
    private final VehicleRepository vehicleRepository;
    private final BrandService brandService;
    private final ModelService modelService;
    private final JwtTokenManager jwtTokenManager;

    public VehicleService(VehicleRepository vehicleRepository, BrandService brandService, ModelService modelService, JwtTokenManager jwtTokenManager) {
        super(vehicleRepository);
        this.vehicleRepository = vehicleRepository;
        this.brandService = brandService;
        this.modelService = modelService;
        this.jwtTokenManager = jwtTokenManager;
    }

    /**
     * Kiralanmak üzere bir araç oluşturmayı sağlayan methodtur.
     * @param dto
     * @return
     */

    // TODO: token hatası. geçersiz token diyor çözümleme yapamıyor ya da eksiklik var.
    public Vehicle createVehicle(CreateVehicleRequestDto dto) {
//        Optional<Long> authId= jwtTokenManager.getIdFromToken(dto.getToken());
//        if (authId.isEmpty()){
//            throw new VehicleServiceException(ErrorType.USER_NOT_FOUND);
//        }
//        Optional<String> userRole=jwtTokenManager.getRoleFromToken(dto.getToken());
//        if (!userRole.isPresent() || !userRole.get().equals("ADMIN")) {
//            throw new VehicleServiceException(ErrorType.UNAUTHORIZED);
//        }

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

    /**
     * Kiralama yapmadan önce kiralık olmayan( NOT_RENTED) ve yakıt miktarı 20 litreden fazla araçları görüntülememizi sağlar.
     * @return
     */
    public List<Vehicle> findVehicleByStatusAndAmountOfFuel() {
        List<Vehicle> vehicleList=findAll();
        return vehicleList.stream().filter(x->x.getStatus().equals(EVehicleStatus.NOT_RENTED) && x.getAmountOfFuel()>20).toList();
    }

    /**
     * Araç seçimi yapmamızı sağlayan methodtur. Kullanıcının girdiği "Id" ile eşleşen bir araç var ise
     * ve status'u NOT_RENTED ise aracı seçmemizi sağlar.
     * @param vehicleId
     * @return
     */
    public Vehicle selectVehicle(String vehicleId) {
        List<Vehicle> vehicleList=findVehicleByStatusAndAmountOfFuel();
        Optional<Vehicle> vehicle=vehicleRepository.findOptionalById(vehicleId);
        if (vehicle.isEmpty()){
            throw new VehicleServiceException(ErrorType.VEHICLE_NOT_FOUND);
        }
        if (!vehicleList.contains(vehicle.get())){
            throw new VehicleServiceException(ErrorType.VEHICLE_IS_NOT_SUITABLE);
        }
        return vehicle.get();
    }


    //TODO: token eklenmeli sadece araç sahipleri adminler yapabilmeli.
    public Vehicle updateVehicle(UpdateVehicleRequestDto dto) {
        Optional<Vehicle> vehicleOptional=vehicleRepository.findOptionalById(dto.getId());
        if (vehicleOptional.isEmpty()){
            throw new VehicleServiceException(ErrorType.VEHICLE_NOT_FOUND);
        }
        Vehicle vehicle=VehicleMapper.INSTANCE.fromUpdateVehicleRequestDtoToVehicle(dto);
        return  update(vehicle);
    }
}
