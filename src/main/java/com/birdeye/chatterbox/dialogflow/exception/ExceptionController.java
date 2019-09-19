package com.birdeye.chatterbox.dialogflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionController
{
    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex)
    {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(ErrorCode.SESSION_NOT_CREATED.getErrorCode());
        error.setErrorReason(ErrorCode.SESSION_NOT_CREATED.getErrorString());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
    }
}