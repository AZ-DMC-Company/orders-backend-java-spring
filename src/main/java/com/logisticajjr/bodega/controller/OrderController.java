package com.logisticajjr.bodega.controller;

import com.logisticajjr.bodega.model.Order;
import com.logisticajjr.bodega.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() throws Exception{
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") Integer id) throws Exception{
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) throws Exception{
        Order obj = service.save(order);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@RequestBody Order order, @PathVariable("id") Integer id) throws Exception{
        Order obj = service.update(order, id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
