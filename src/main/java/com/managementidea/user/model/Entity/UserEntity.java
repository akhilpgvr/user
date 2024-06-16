package com.managementidea.user.model.Entity;

import com.managementidea.user.model.Request.PersonnelInfoDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user-mgmt")
public class UserEntity {

    @Id
    @Generated
    private String id;

    private String userName;
    private String password;
    private PersonnelInfoDTO userInfo;
}
