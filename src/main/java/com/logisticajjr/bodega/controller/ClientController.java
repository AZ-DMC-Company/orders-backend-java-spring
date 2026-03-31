package com.logisticajjr.bodega.controller;

import com.logisticajjr.bodega.model.Client;
import com.logisticajjr.bodega.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() throws Exception{
        List<Client> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") Integer id) throws Exception{
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) throws Exception{
        Client obj = service.save(client);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable("id") Integer id) throws Exception{
        Client obj = service.update(client, id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
