package com.birdeye.chatterbox.dialogflow.service;

import com.birdeye.chatterbox.dialogflow.configuration.DialogFlowProperties;
import com.birdeye.chatterbox.dialogflow.enums.ContentType;
import com.birdeye.chatterbox.dialogflow.enums.MessageType;
import com.birdeye.chatterbox.dialogflow.keySpace.Session;
import com.birdeye.chatterbox.dialogflow.model.chatbot.*;
import com.birdeye.chatterbox.dialogflow.model.request.QueryRequest;
import com.birdeye.chatterbox.dialogflow.model.response.QueryResponse;
import com.birdeye.chatterbox.dialogflow.util.ChatterBoxUtil;
import com.google.cloud.dialogflow.v2.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class DialogFlowQueryServiceImpl implements DialogFlowQueryService
{
    private final DialogFlowProperties dialogFlowProperties;

    private final SessionService sessionService;

    @Override
    public QueryResponse sendQueryToDialogFlow(QueryRequest queryRequest) throws IOException
    {
        String projectId = dialogFlowProperties.getProjectId();
        String languageCode = dialogFlowProperties.getLanguageCode();
        Session session = ChatterBoxUtil.createSession();
        //Session session = sessionService.validateAndGetSession();

        try (SessionsClient sessionsClient = SessionsClient.create())
        {
            SessionName sessionName = SessionName.of(projectId, session.getSessionId());
            TextInput.Builder textInput = TextInput.newBuilder().setText(queryRequest.getQueryText()).setLanguageCode
                    (languageCode);
            QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();
            DetectIntentResponse response = sessionsClient.detectIntent(sessionName, queryInput);

            return processResponse(response);
        }
    }

    private QueryResponse processResponse(DetectIntentResponse response)
    {
        QueryResult queryResult = response.getQueryResult();

        List<Intent.Message> fulfillmentMessagesList = queryResult.getFulfillmentMessagesList();

        List<Message> messages = fulfillmentMessagesList.stream()
                .map(Intent.Message::getCard).map(card -> createMessage(card, queryResult))
                .collect(Collectors.toList());

        List<Button> buttons = fulfillmentMessagesList.stream().map(Intent.Message::getCard)
                .flatMap(card -> card.getButtonsList().stream().map(button -> createButton(button)))
                .collect(Collectors.toList());

        Action action = new Action();
        action.setButton(buttons);
        QueryResponse queryResponse = new QueryResponse();
        queryResponse.setFulfillmentText(queryResult.getFulfillmentText());
        queryResponse.setMessage(messages);
        queryResponse.setAction(action);
        log.info("{}",queryResponse);
        return queryResponse;
    }

    private Button createButton(Intent.Message.Card.Button button)
    {
        Button button1 = new Button();
        button1.setText(button.getText());
        button1.setValue(button.getPostback());
        return button1;
    }

    private Message createMessage(Intent.Message.Card card, QueryResult queryResult)
    {
        Message message = new Message();
        message.setType(MessageType.TEXT.getMessageType());
        Content content = new Content();
        content.setType(card.getSubtitle().toLowerCase());
        Data data = new Data();
        if (card.getSubtitle().equalsIgnoreCase(ContentType.LINK.getContentType()))
        {
            data.setName(card.getTitle());
            data.setUrl(card.getImageUri());
        }
        else if (card.getSubtitle().equalsIgnoreCase(ContentType.IMAGE.getContentType()))
        {
            data.setName(card.getTitle());
            data.setUrl(card.getImageUri());
        }
        else
        {
            return new Message();
        }
        content.setData(data);
        message.setContent(content);
        return message;
    }
}
