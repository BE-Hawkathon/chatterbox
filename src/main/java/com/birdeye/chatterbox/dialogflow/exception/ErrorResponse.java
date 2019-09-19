package com.birdeye.chatterbox.dialogflow.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse
{
    private int errorCode;

    private String errorReason;

    private String message;
}
