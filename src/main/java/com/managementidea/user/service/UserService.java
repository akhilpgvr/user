package com.managementidea.user.service;

import com.managementidea.user.model.Entity.UserEntity;
import com.managementidea.user.model.Request.PersonnelInfoDTO;
import com.managementidea.user.model.repo.UserRepo;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Void savePersonnelInfo(PersonnelInfoDTO request) {

        log.info("save Personnel-info to entity");
        UserEntity user = new UserEntity();
        user.setUserInfo(request);
        userRepo.save(user);
        return null;
    }
}
