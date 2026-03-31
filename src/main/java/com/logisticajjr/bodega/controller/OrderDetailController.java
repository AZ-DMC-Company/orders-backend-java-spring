package com.logisticajjr.bodega.controller;

import com.logisticajjr.bodega.model.OrderDetail;
import com.logisticajjr.bodega.service.IOrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetails")
@RequiredArgsConstructor
public class OrderDetailController {

    private final IOrderDetailService service;

    @GetMapping
    public ResponseEntity<List<OrderDetail>> findAll() throws Exception{
        List<OrderDetail> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> findById(@PathVariable("id") Integer id) throws Exception{
        OrderDetail obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<OrderDetail> create(@RequestBody OrderDetail orderdetail) throws Exception{
        OrderDetail obj = service.save(orderdetail);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> update(@RequestBody OrderDetail orderdetail, @PathVariable("id") Integer id) throws Exception{
        OrderDetail obj = service.update(orderdetail, id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
