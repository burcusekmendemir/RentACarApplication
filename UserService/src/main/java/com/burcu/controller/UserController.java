package com.burcu.controller;

import com.burcu.dto.request.CreateUserRequestDto;
import com.burcu.dto.request.UpdateUserRequestDto;
import com.burcu.entity.User;
import com.burcu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.burcu.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserController {

    private final UserService userService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto){
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PutMapping(UPDATE_USER)
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequestDto dto){
        return ResponseEntity.ok(userService.updateUser(dto));
    }

    @GetMapping(ACTIVATE_USER +"/{authId}")
    public ResponseEntity<Boolean> activateUser(@PathVariable Long authId){
        return ResponseEntity.ok(userService.activateUser(authId));
    }
}
