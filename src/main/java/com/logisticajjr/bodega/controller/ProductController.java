package com.logisticajjr.bodega.controller;

import com.logisticajjr.bodega.model.Product;
import com.logisticajjr.bodega.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() throws Exception{
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) throws Exception{
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) throws Exception{
        Product obj = service.save(product);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable("id") Integer id) throws Exception {
        Product obj = service.update(product, id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping
    public ResponseEntity<Product> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
