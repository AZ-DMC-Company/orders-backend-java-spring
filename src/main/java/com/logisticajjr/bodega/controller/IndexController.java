package com.logisticajjr.bodega.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class IndexController {

    @GetMapping
    public String index() {
        String student = "Jose Bautista";
        return "Bienvenido::: " +  student;
    }
}
