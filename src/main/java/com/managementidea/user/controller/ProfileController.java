package com.managementidea.user.controller;

import com.managementidea.user.model.request.UpdateProfileDTO;
import com.managementidea.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public ResponseEntity<Void> updateProfile(@RequestParam String mobileNo, @RequestBody UpdateProfileDTO request) {

        log.info("update communication medium or username or password");
        request.setMobileNo(mobileNo);
        return new ResponseEntity<>(userService.updateProfile(request), HttpStatus.OK);
    }
}
