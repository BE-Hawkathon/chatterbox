package com.birdeye.chatterbox.dialogflow.enums;

import lombok.Getter;

@Getter
public enum MessageType
{
    TEXT("text"), EMBED("embed");

    private String messageType;

    MessageType(String messageType)
    {
        this.messageType = messageType;
    }
}
