package com.burcu.service;

import com.burcu.dto.request.CreateBrandRequestDto;
import com.burcu.entity.Brand;
import com.burcu.repository.BrandRepository;
import com.burcu.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService extends ServiceManager<Brand,String> {

    private final BrandRepository brandRepository;
    public BrandService(BrandRepository brandRepository) {
        super(brandRepository);
        this.brandRepository = brandRepository;
    }

    public Brand createBrand(CreateBrandRequestDto dto){
        Optional<Brand> brandOptional=brandRepository.findByBrandName(dto.getBrandName());
        if (brandOptional.isPresent()){
            return brandOptional.get();
        }
        Brand brand=Brand.builder()
                .brandName(dto.getBrandName())
                .build();
        return save(brand);

    }
}
