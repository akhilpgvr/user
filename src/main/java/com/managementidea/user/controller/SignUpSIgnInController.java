package com.managementidea.user.controller;

import com.managementidea.user.model.request.PasswordDTO;
import com.managementidea.user.model.request.PersonnelInfoDTO;
import com.managementidea.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/signup-signin")
public class SignUpSIgnInController {

    @Autowired
    private UserService userService;

    @Operation(summary = "This api is for entering Personnel information", description = "")
    @PostMapping("/personnel-info")
    private ResponseEntity<Void> savePersonnelInfo(@RequestBody PersonnelInfoDTO request) {

        log.info("Save personnel info");
        return new ResponseEntity<>(userService.savePersonnelInfo(request), HttpStatus.OK);
    }

    @Operation(summary = "This api is for entering username", description = "")
    @PostMapping("/username")
    public ResponseEntity<Void> createUserName(@RequestParam String mobileNo, @RequestParam String userName) {

        log.info("create userName");
        return new ResponseEntity<>(userService.createUserName(mobileNo, userName), HttpStatus.OK);
    }

    @Operation(summary = "This api is for entering password", description = "")
    @PostMapping("/password")
    public ResponseEntity<Void> createPassword(@RequestBody PasswordDTO request) {

        log.info("create password");
        return new ResponseEntity<>(userService.createPassword(request), HttpStatus.OK);
    }
}
