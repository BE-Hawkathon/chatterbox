package com.birdeye.chatterbox.dialogflow.service;

import com.birdeye.chatterbox.dialogflow.model.request.QueryRequest;

import java.io.IOException;

public interface DialogFlowQueryService
{
    String sendQueryToDialogFlow(QueryRequest queryRequest) throws IOException;
}
