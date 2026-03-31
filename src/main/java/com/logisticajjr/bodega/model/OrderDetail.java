package com.logisticajjr.bodega.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idOrderDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_ORDER"))
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDERDETAIL_PRODUCT"))
    private Product product;
    private Integer quantity;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();
}
