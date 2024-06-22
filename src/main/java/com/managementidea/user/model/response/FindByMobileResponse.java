package com.managementidea.user.model.response;

import com.managementidea.user.model.backOffice.PersonnelInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindByMobileResponse {

    private String userName;
    private PersonnelInfo userInfo;

}
