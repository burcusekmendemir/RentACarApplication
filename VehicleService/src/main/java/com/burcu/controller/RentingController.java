package com.burcu.controller;

import com.burcu.dto.request.CreateRentingRequestDto;
import com.burcu.entity.Renting;
import com.burcu.service.RentingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.burcu.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RENTING)
public class RentingController {
    private final RentingService rentingService;

    @PostMapping(RENT_CAR)
    public ResponseEntity<Boolean> rentCar(@RequestBody CreateRentingRequestDto dto){
        return ResponseEntity.ok(rentingService.rentCar(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Renting>> findAll(){return ResponseEntity.ok(rentingService.findAll());}
}
