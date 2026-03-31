package com.logisticajjr.bodega.controller;

import com.logisticajjr.bodega.model.UserType;
import com.logisticajjr.bodega.service.IUserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usertypes")
@RequiredArgsConstructor
public class UserTypeController {

    private final IUserTypeService service;

    @GetMapping
    public ResponseEntity<List<UserType>> findAll() throws Exception{
        List<UserType> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserType> findById(@PathVariable("id") Integer id) throws Exception{
        UserType obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<UserType> create(@RequestBody UserType userType) throws Exception{
        UserType obj = service.save(userType);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserType> update(@RequestBody UserType userType, @PathVariable("id") Integer id) throws Exception{
        UserType obj = service.update(userType, id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
