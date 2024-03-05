package com.burcu.controller;

import com.burcu.dto.request.CreateRentingRequestDto;
import com.burcu.service.RentingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
