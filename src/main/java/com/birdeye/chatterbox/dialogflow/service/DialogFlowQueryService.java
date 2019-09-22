package com.birdeye.chatterbox.dialogflow.service;

import com.birdeye.chatterbox.dialogflow.model.request.QueryRequest;
import com.birdeye.chatterbox.dialogflow.model.response.QueryResponse;

import java.io.IOException;

public interface DialogFlowQueryService
{
    QueryResponse sendQueryToDialogFlow(QueryRequest queryRequest) throws IOException;
}
