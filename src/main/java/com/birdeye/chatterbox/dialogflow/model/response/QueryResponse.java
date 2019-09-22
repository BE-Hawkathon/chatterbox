package com.birdeye.chatterbox.dialogflow.model.response;

import com.birdeye.chatterbox.dialogflow.model.chatbot.Action;
import com.birdeye.chatterbox.dialogflow.model.chatbot.Message;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class QueryResponse
{
    private String fulfillmentText;

    private List<Message> message;

    private Action action;
}
