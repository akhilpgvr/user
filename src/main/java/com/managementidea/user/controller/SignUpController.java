package com.managementidea.user.controller;

import com.managementidea.user.model.request.PersonnelInfoDTO;
import com.managementidea.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "This api is for entering Personnel information")
    @PostMapping("/personnel-info")
    private ResponseEntity<Void> savePersonnelInfo(@RequestBody PersonnelInfoDTO request) {

        log.info("Save personnel info");
        return new ResponseEntity<>(userService.savePersonnelInfo(request), HttpStatus.OK);
    }

    @ApiOperation(value = "This api is for entering username")
    @PostMapping("/username")
    public ResponseEntity<Void> createUserName(@RequestParam String mobileNo, @RequestParam String userName) {

        log.info("create userName");
        return new ResponseEntity<>(userService.createUserName(mobileNo, userName), HttpStatus.OK);
    }
}
