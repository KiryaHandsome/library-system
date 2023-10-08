package com.modsen.book.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException {

    public UserNotFoundException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
