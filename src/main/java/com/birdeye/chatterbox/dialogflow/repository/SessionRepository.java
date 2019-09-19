package com.birdeye.chatterbox.dialogflow.repository;

import com.birdeye.chatterbox.dialogflow.keySpace.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, String>
{
}
