package com.managementidea.user.model.repo;

import com.managementidea.user.model.entities.UserEntity;
import com.managementidea.user.model.enums.UserTypeEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<UserEntity, String> {

    @Query("{ $or: [ {'userInfo.mobileNo': ?0}, {'userInfo.email': ?1} ] }")
    Optional<UserEntity> findByMobileNoOrEmail(String mobileNo, String email);

    @Query("{'userInfo.mobileNo': ?0}")
    Optional<UserEntity> findByMobileNo(String mobileNo);

    Optional<UserEntity> findByUserName(String userName);

    @Query("{ $and: [ {'userInfo.mobileNo': ?0}, {'userInfo.userType': ?1} ] }")
    Optional<UserEntity> findByMobileNoAndUserType(String mobileNo, UserTypeEnum userType);
}
