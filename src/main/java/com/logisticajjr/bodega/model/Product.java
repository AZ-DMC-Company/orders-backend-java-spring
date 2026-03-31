package com.logisticajjr.bodega.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idProduct;
    private String name;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();

}
