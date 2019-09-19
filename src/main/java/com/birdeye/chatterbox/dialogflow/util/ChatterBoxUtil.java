package com.birdeye.chatterbox.dialogflow.util;

import com.birdeye.chatterbox.dialogflow.keySpace.Session;
import com.birdeye.chatterbox.dialogflow.model.response.QueryResponse;

public final class ChatterBoxUtil
{
    private ChatterBoxUtil()
    {
    }

    public static QueryResponse queryResultMapper()
    {
        return null;
    }

    public static Session createSession()
    {
        return new Session("mayank", 4231L);
    }
}
