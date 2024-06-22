package com.managementidea.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDTO {

    private String mobileNo;
    private String password;
    private String reEnteredKey; // reentered password
}
