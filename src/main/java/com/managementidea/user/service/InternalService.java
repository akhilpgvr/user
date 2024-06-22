package com.managementidea.user.service;

import com.managementidea.user.model.entities.UserEntity;
import com.managementidea.user.model.enums.UserTypeEnum;
import com.managementidea.user.model.response.FindByMobileResponse;
import com.managementidea.user.utils.Helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InternalService {

    @Autowired
    private UserService userService;

    public FindByMobileResponse findByMobileNoAndUserType(String mobileNo, UserTypeEnum userType) {

        log.info("calling function to fetch using mobileNo");
        UserEntity user = userService.findByMobileNoAndUserType(mobileNo, userType);
        return Helper.copyProperties(user, new FindByMobileResponse());
    }
}
