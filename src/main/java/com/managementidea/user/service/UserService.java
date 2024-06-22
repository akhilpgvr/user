package com.managementidea.user.service;

import com.managementidea.user.exceptions.PasswordNotMatchException;
import com.managementidea.user.exceptions.UserExistsException;
import com.managementidea.user.exceptions.UserNameExistsException;
import com.managementidea.user.exceptions.UserNotExistsException;
import com.managementidea.user.model.backOffice.PersonnelInfo;
import com.managementidea.user.model.entities.UserEntity;
import com.managementidea.user.model.enums.ProfileUpdateEnum;
import com.managementidea.user.model.enums.UserTypeEnum;
import com.managementidea.user.model.repo.UserRepo;
import com.managementidea.user.model.request.PasswordDTO;
import com.managementidea.user.model.request.PersonnelInfoDTO;
import com.managementidea.user.model.request.UpdateProfileDTO;
import com.managementidea.user.utils.Helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public UserEntity findByMobileNo(String mobileNo) {

        log.info("checking user existence BY mobileNo: {}", mobileNo);
        Optional<UserEntity> userRefByMob = userRepo.findByMobileNo(mobileNo);
        if(userRefByMob.isPresent()) {
            return userRefByMob.get();
        }
        else {
            log.error("User not exists for mobileNo: {}",mobileNo);
            throw new UserNotExistsException("User not exists for mobileNo: "+mobileNo);
        }

    }

    public UserEntity findByMobileNoAndUserType(String mobileNo, UserTypeEnum userType) {

        log.info("checking user existence BY mobileNo: {} and userType: {}", mobileNo, userType.name());
        Optional<UserEntity> userRefByMob = userRepo.findByMobileNoAndUserType(mobileNo, userType);
        if(userRefByMob.isPresent()) {
            return userRefByMob.get();
        }
        else {
            log.error("User not exists for mobileNo: {} and userType: {}", mobileNo, userType.name());
            throw new UserNotExistsException("User not exists for mobileNo: "+mobileNo+ " and userType: "+userType.name());
        }
    }

    public Void savePersonnelInfo(PersonnelInfoDTO request) {

        log.info("checking user existence by mobileNo and email");
        checkUserByMobileOrEmail(request.getMobileNo(), request.getEmail());

        log.info("save Personnel-info to entity");
        UserEntity user = new UserEntity();
        PersonnelInfo personnelInfo = Helper.copyProperties(request, new PersonnelInfo());

        user.setUserInfo(personnelInfo);
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

    public Void createUserName(String mobileNo, String userName) {

        //perform username validation
        UserEntity user = findByMobileNo(mobileNo);
        log.info("checking username existence");
        Optional<UserEntity> userRefByUserName = userRepo.findByUserName(userName);
        if(userRefByUserName.isPresent()) throw new UserNameExistsException("UserName: "+userName+" already exists");

        user.setUserName(userName);
        userRepo.save(user);
        return null;
    }

    public Void createPassword(PasswordDTO request) {

        String password = request.getPassword();
        log.info("Comparing password and re-entered password");
        if(!password.equalsIgnoreCase(request.getReEnteredKey())){
            log.error("password and re-entered password not matches");
            throw new PasswordNotMatchException("password and re-entered password not matches");
        }

        UserEntity user = findByMobileNo(request.getMobileNo());
        user.setPassword(password);
        userRepo.save(user);
        return null;
    }

    public Void updateProfile(UpdateProfileDTO request) {


        log.info("selecting the update function for: {}", request.getUpdatedData().name());
        String mobileNo = request.getMobileNo();

        switch(request.getUpdatedData()){

            case ProfileUpdateEnum.USERNAME -> {

                log.info("updating username to: {}", request.getNewUserName());
                createUserName(request.getMobileNo(), request.getNewUserName());
            }
            case ProfileUpdateEnum.PASSWORD -> {

                log.info("updating password to: {}", request.getNewPassword());
                createPassword(new PasswordDTO(mobileNo, request.getNewPassword(), request.getReEnteredPassword()));
            }

            case ProfileUpdateEnum.MOBILE -> {

                log.info("fetching user with mobileNo: {}", request.getMobileNo());
                UserEntity user = findByMobileNo(mobileNo);

                log.info("updating mobileNo to: {}", request.getNewMobileNo());
                user.getUserInfo().setMobCountryCode(request.getNewMobCountryCode());
                user.getUserInfo().setMobileNo(request.getNewMobileNo());
                userRepo.save(user);
            }

            case ProfileUpdateEnum.EMAIL -> {

                log.info("fetching user with mobileNo: {}", request.getMobileNo());
                UserEntity user = findByMobileNo(mobileNo);

                log.info("updating email to: {}", request.getNewEmail());
                user.getUserInfo().setEmail(request.getNewEmail());
                user.getUserInfo().setMobileNo(request.getMobileNo());
                userRepo.save(user);
            }

        }

        return null;
    }
}
