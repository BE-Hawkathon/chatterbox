package com.birdeye.chatterbox.dialogflow.service;

import com.birdeye.chatterbox.dialogflow.keySpace.Session;
import lombok.AllArgsConstructor;
import com.birdeye.chatterbox.dialogflow.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SessionServiceImpl implements SessionService
{
    private final SessionRepository sessionRepository;

    @Override
    public Session validateAndGetSession(String sessionId, Long businessId)
    {
        return findBySessionId(sessionId).isPresent() ? findBySessionId(sessionId).get() : saveSession(new Session
                (sessionId, businessId));
    }

    private Session saveSession(Session session)
    {
        return sessionRepository.save(session);
    }

    private Optional<Session> findBySessionId(String sessionId)
    {
        return sessionRepository.findById(sessionId);
    }
}
