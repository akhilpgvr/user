package com.managementidea.user.exceptions;

public class UserNameExistsException extends RuntimeException{

    public UserNameExistsException(String message){
        super(message);
    }
}
