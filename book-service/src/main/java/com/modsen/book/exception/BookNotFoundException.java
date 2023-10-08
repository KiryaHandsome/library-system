package com.modsen.book.exception;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends BaseException {

    public BookNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
