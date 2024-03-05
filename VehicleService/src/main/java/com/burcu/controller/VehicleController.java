package com.burcu.controller;

import com.burcu.dto.request.CreateVehicleRequestDto;
import com.burcu.entity.Vehicle;
import com.burcu.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.burcu.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VEHICLE)
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping(CREATE_VEHICLE)
    public ResponseEntity<Vehicle> createVehicle(@RequestBody CreateVehicleRequestDto dto){
        return ResponseEntity.ok(vehicleService.createVehicle(dto));
    }

}
