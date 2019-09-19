package com.birdeye.chatterbox.dialogflow.controller;

import com.birdeye.chatterbox.dialogflow.model.request.QueryRequest;
import com.birdeye.chatterbox.dialogflow.service.DialogFlowQueryService;
import lombok.AllArgsConstructor;
import com.birdeye.chatterbox.dialogflow.exception.ErrorCode;
import com.birdeye.chatterbox.dialogflow.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String sendQueryToDialogFlow(@RequestBody QueryRequest queryRequest) throws IOException
    {
        return dialogFlowQueryService.sendQueryToDialogFlow(queryRequest);
    }
}
