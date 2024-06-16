package com.managementidea.user.exceptions;

public class UserExistsException extends RuntimeException{

    public UserExistsException(String message){
        super(message);
    }
}
