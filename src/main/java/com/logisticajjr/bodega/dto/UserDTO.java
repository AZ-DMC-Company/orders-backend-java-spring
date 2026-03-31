package com.logisticajjr.bodega.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer idUser;
    private String username;
    private String firstName;
    private String lastName;
    private Integer idUserType;
    private String userTypeName;
}
