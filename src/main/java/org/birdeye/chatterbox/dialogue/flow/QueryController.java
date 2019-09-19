package org.birdeye.chatterbox.dialogue.flow;

import com.google.cloud.dialogflow.v2.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatbot")
public class QueryController
{
    @PostMapping("/query")
    public String detectIntentTexts(@RequestBody QueryRequest queryRequest) throws Exception
    {
        String projectId = "chatteragent-wopyjy";
        //Create this sessionId as per businessId and secret Key.
        String sessionId = "mayank";
        String languageCode = "en-US";
        try (SessionsClient sessionsClient = SessionsClient.create())
        {
            SessionName session = SessionName.of(projectId, sessionId);
            TextInput.Builder textInput =
                    TextInput.newBuilder().setText(queryRequest.getQueryText()).setLanguageCode(languageCode);
            QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();
            DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
            QueryResult queryResult = response.getQueryResult();

            return queryResult.getFulfillmentText();
        }
    }
}
