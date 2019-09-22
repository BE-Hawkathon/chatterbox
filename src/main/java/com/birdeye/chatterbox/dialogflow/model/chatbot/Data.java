package com.birdeye.chatterbox.dialogflow.model.chatbot;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data
{
    private String text;

    private String name;

    private String url;
}
