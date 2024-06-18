package com.managementidea.user.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDTO {

    @Size(min = 10, max = 10)
    private String mobileNo;
    @Min(8)
    @Max(12)
    private String password;
    @Min(8)
    @Max(12)
    private String reEnteredKey; // reentered password
}
