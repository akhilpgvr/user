package com.managementidea.user.service;

import com.managementidea.user.exceptions.UserExistsException;
import com.managementidea.user.model.Entity.UserEntity;
import com.managementidea.user.model.Request.PersonnelInfoDTO;
import com.managementidea.user.model.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Void savePersonnelInfo(PersonnelInfoDTO request) {

        log.info("checking user existence by mobileNo and email");
        checkUserByMobileOrEmail(request.getMobileNo(), request.getEmail());

        log.info("save Personnel-info to entity");
        UserEntity user = new UserEntity();
        user.setUserInfo(request);
        userRepo.save(user);
        return null;
    }

    public void checkUserByMobileOrEmail(String mobileNo, String email) {

        log.info("checking user existence by mobileNo: {}, email: {}", mobileNo, email);
        Optional<UserEntity> userRef = userRepo.findByMobileNoOrEmail(mobileNo, email);
        if (userRef.isPresent()) {
            log.error("user already exists by mobileNo or email");
            throw new UserExistsException("user already exists by mobileNo or email");
        }
    }
}
