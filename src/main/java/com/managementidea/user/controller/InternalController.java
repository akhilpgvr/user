package com.managementidea.user.controller;

import com.managementidea.user.model.enums.UserTypeEnum;
import com.managementidea.user.model.response.FindByMobileResponse;
import com.managementidea.user.service.InternalService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/internal")
public class InternalController {

    @Autowired
    private InternalService internalService;

    @Operation(summary = "Api to get user details based on mobileNo and userType", description = "")
    @GetMapping("/find-by/mobno-usertype/{mobileNo}")
    public ResponseEntity<FindByMobileResponse> findByMobileNoAndUserType(@PathVariable(name = "mobileNo") String mobileNo, @RequestParam UserTypeEnum userType) {

        log.info("search for user with mobileNo: {} and userType: {}", mobileNo, userType);
        return new ResponseEntity<>(internalService.findByMobileNoAndUserType(mobileNo, userType), HttpStatus.OK);
    }
}
