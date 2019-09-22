package com.birdeye.chatterbox.dialogflow.enums;

import lombok.Getter;

@Getter
public enum ContentType
{
    LINK("link"), IMAGE("image"), TEXT("text");

    private String contentType;

    ContentType(String contentType)
    {
        this.contentType = contentType;
    }
}
