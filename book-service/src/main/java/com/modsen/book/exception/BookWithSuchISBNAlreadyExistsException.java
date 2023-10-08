package com.modsen.book.exception;

import org.springframework.http.HttpStatus;

public class BookWithSuchISBNAlreadyExistsException extends BaseException {

    public BookWithSuchISBNAlreadyExistsException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
