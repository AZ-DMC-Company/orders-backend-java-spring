package com.logisticajjr.bodega.controller;

import com.logisticajjr.bodega.dto.UserDTO;
import com.logisticajjr.bodega.model.User;
import com.logisticajjr.bodega.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService service;
    private final ModelMapper modelMapper;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody User user) throws Exception{
        String username = user.getUsername();
        String password = user.getPassword();
        User obj = service.login(username, password);
        if(obj!=null){
            return ResponseEntity.ok(modelMapper.map(obj, UserDTO.class));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
