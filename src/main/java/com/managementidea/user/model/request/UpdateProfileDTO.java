package com.managementidea.user.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.managementidea.user.model.enums.ProfileUpdateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileDTO {

    //this is ignored because this is the key to identify the user an this won't be part of request body
    @JsonIgnore
    private String mobileNo;

    private ProfileUpdateEnum updatedData;
    private String newUserName;
    private String newPassword;
    private String reEnteredPassword;
    private String newMobCountryCode;
    private String newMobileNo;
    private String newEmail;
}
