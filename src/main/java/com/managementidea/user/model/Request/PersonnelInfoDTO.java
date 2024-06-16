package com.managementidea.user.model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelInfoDTO {

    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String mobCountryCode;
    private String mobileNo;
    private String email;
    private String prefCommunication;
}
