package com.modsen.book.exception;

import com.modsen.book.dto.ErrorEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorEntity> handleRuntime(RuntimeException ex) {
        ErrorEntity response = new ErrorEntity(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorEntity> handleBookNotFound(BookNotFoundException ex) {
        ErrorEntity response = new ErrorEntity(ex.getMessage());
        return ResponseEntity
                .status(ex.getStatusCode())
                .body(response);
    }
}
