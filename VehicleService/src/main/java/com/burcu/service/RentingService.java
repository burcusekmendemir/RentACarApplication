package com.burcu.service;

import com.burcu.dto.request.CreateRentingRequestDto;
import com.burcu.entity.Renting;
import com.burcu.repository.RentingRepository;
import com.burcu.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class RentingService extends ServiceManager<Renting,String> {
    private final RentingRepository rentingRepository;
    public RentingService(RentingRepository rentingRepository) {
        super(rentingRepository);
        this.rentingRepository = rentingRepository;
    }

    //TODO: kiralama işlemi oluşturulacak!!
    public Boolean rentCar(CreateRentingRequestDto dto) {
        return true;
    }
}
