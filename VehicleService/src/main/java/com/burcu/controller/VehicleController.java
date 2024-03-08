package com.burcu.controller;

import com.burcu.dto.request.*;
import com.burcu.dto.response.VehicleFuelResponseDto;
import com.burcu.dto.response.VehicleStatusResponseDto;
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
    public ResponseEntity<List<Vehicle>> findVehicleByStatusAndAmountOfFuel(@RequestParam String token){
        return ResponseEntity.ok(vehicleService.findVehicleByStatusAndAmountOfFuel(token));
    }

    @PostMapping(SELECT_VEHICLE)
    public ResponseEntity<Vehicle> selectVehicle(@RequestBody SelectVehicleRequestDto dto){
        return ResponseEntity.ok(vehicleService.selectVehicle(dto));
    }

    @PostMapping(UPDATE_VEHICLE)
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody UpdateVehicleRequestDto dto){
        return ResponseEntity.ok(vehicleService.updateVehicle(dto));
    }

    @PostMapping(UPDATE_PRICE)
    public ResponseEntity<Vehicle> updatePrice(@RequestBody UpdatePriceRequestDto dto){
        return ResponseEntity.ok(vehicleService.updatePrice(dto));
    }

    @GetMapping(VIEW_VEHICLE_STATUS)
    public ResponseEntity<List<VehicleStatusResponseDto>> viewVehicleStatus(@RequestParam String token){
        return ResponseEntity.ok(vehicleService.viewVehicleStatus(token));
    }

    @PostMapping(FUELING)
    public ResponseEntity<Boolean> fueling(@RequestBody UpdateFuelRequestDto dto){
        return ResponseEntity.ok(vehicleService.fueling(dto));
    }

    @GetMapping(FIND_VEHICLE_BY_FUEL)
    public ResponseEntity<List<VehicleFuelResponseDto>> findVehicleByFuel(@RequestParam String token){
        return ResponseEntity.ok(vehicleService.findVehicleByFuel(token));
    }

}
