package com.managementidea.user.model.repo;

import com.managementidea.user.model.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface UserRepo extends MongoRepository<UserEntity, String> {

}
