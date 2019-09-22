package com.birdeye.chatterbox.dialogflow.controller;

import com.birdeye.chatterbox.dialogflow.model.request.QueryRequest;
import com.birdeye.chatterbox.dialogflow.model.response.QueryResponse;
import com.birdeye.chatterbox.dialogflow.service.DialogFlowQueryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/chatbot")
@AllArgsConstructor
public class DialogFlowQueryController
{
    private final DialogFlowQueryService dialogFlowQueryService;

    @CrossOrigin
    @PostMapping("/query/dialogflow")
    public QueryResponse sendQueryToDialogFlow(@RequestBody QueryRequest queryRequest) throws IOException
    {
        return dialogFlowQueryService.sendQueryToDialogFlow(queryRequest);
    }
}
