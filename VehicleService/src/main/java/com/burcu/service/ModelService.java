package com.burcu.service;


import com.burcu.dto.request.CreateModelRequestDto;
import com.burcu.entity.Model;
import com.burcu.repository.ModelRepository;
import com.burcu.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelService extends ServiceManager<Model,String> {
    private final ModelRepository modelRepository;
    public ModelService(ModelRepository modelRepository) {
        super(modelRepository);
        this.modelRepository = modelRepository;
    }

    public Model createModel(CreateModelRequestDto dto){
        Optional<Model> modelOptional=modelRepository.findByModelName(dto.getModelName());
        if (modelOptional.isPresent()){
            return modelOptional.get();
        }

        Model model=Model.builder()
                .modelName(dto.getModelName())
                .brandId(dto.getBrandId())
                .build();
        return save(model);
    }
}
