package com.birdeye.chatterbox.dialogflow.util;

import com.birdeye.chatterbox.dialogflow.keySpace.Session;
import com.birdeye.chatterbox.dialogflow.model.response.QueryResponseV3;

public final class ChatterBoxUtil
{
    private ChatterBoxUtil()
    {
    }

    public static QueryResponseV3 queryResultMapper()
    {
        return null;
    }

    public static Session createSession()
    {
        return new Session("mayank", 4231L);
    }
}
