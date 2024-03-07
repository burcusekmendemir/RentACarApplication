package com.burcu.controller;

import com.burcu.dto.request.CreateVehicleRequestDto;
import com.burcu.dto.request.UpdateVehicleRequestDto;
import com.burcu.entity.Vehicle;
import com.burcu.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Vehicle>> findAll(){
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @GetMapping(FIND_VEHICLES_BY_STATUS_AND_AMOUNT_OF_FUEL)
    public ResponseEntity<List<Vehicle>> findVehicleByStatusAndAmountOfFuel(){
        return ResponseEntity.ok(vehicleService.findVehicleByStatusAndAmountOfFuel());
    }

    @GetMapping(SELECT_VEHICLE)
    public ResponseEntity<Vehicle> selectVehicle(@RequestParam String vehicleId){
        return ResponseEntity.ok(vehicleService.selectVehicle(vehicleId));
    }

    @PostMapping(UPDATE_VEHICLE)
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody UpdateVehicleRequestDto dto){
        return ResponseEntity.ok(vehicleService.updateVehicle(dto));
    }

}
