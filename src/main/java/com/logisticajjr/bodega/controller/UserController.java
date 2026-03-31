package com.logisticajjr.bodega.controller;

import com.logisticajjr.bodega.dto.UserDTO;
import com.logisticajjr.bodega.model.User;
import com.logisticajjr.bodega.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() throws Exception{
        List<UserDTO> list = service.findAll().stream()
                .map(e -> modelMapper.map(e, UserDTO.class)).toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable("id") Integer id) throws Exception{
        User user = service.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(user, UserDTO.class));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) throws Exception{
        User obj = service.save(user);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable("id") Integer id) throws Exception{
        User obj = service.update(user, id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
