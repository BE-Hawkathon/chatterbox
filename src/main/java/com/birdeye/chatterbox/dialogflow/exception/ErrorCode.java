package com.birdeye.chatterbox.dialogflow.exception;

import lombok.Getter;

@Getter
public enum ErrorCode
{
    SESSION_NOT_CREATED(101, "Session could not be created");

    private int errorCode;

    private String errorString;

    ErrorCode(int errorCode, String errorString)
    {
        this.errorCode = errorCode;
        this.errorString = errorString;
    }
}