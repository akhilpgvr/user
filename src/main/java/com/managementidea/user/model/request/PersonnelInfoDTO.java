package com.managementidea.user.model.request;

import com.managementidea.user.model.enums.UserTypeEnum;
import com.managementidea.user.model.enums.GenderEnum;
import com.managementidea.user.model.enums.PrefCommunicaionEnum;
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
    private GenderEnum gender;
    private UserTypeEnum userType;
    private String mobCountryCode;
    private String mobileNo;
    private String email;
    private PrefCommunicaionEnum prefCommunication;
}
