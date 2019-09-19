package com.birdeye.chatterbox.dialogflow.service;

import com.google.cloud.dialogflow.v2.*;
import lombok.AllArgsConstructor;
import com.birdeye.chatterbox.dialogflow.configuration.DialogFlowProperties;
import com.birdeye.chatterbox.dialogflow.keySpace.Session;
import com.birdeye.chatterbox.dialogflow.model.request.QueryRequest;
import com.birdeye.chatterbox.dialogflow.util.ChatterBoxUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@AllArgsConstructor
public class DialogFlowQueryServiceImpl implements DialogFlowQueryService
{
    private final DialogFlowProperties dialogFlowProperties;

    private final SessionService sessionService;

    @Override
    public String sendQueryToDialogFlow(QueryRequest queryRequest) throws IOException
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
            QueryResult queryResult = response.getQueryResult();
            return queryResult.getFulfillmentText();
        }
    }
}
