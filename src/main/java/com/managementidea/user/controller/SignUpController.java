package com.managementidea.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/signup")
public class SignUpController {

    @PostMapping
    public String saveName(@RequestParam String name) {
        return name;
    }
}
