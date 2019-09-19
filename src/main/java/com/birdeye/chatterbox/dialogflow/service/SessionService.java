package com.birdeye.chatterbox.dialogflow.service;

import com.birdeye.chatterbox.dialogflow.keySpace.Session;

public interface SessionService
{
    Session validateAndGetSession(String sessionId, Long businessId);
}
