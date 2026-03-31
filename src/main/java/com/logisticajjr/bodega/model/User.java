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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUser;

    @Column(nullable = false, length = 60, unique = true)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();
}
