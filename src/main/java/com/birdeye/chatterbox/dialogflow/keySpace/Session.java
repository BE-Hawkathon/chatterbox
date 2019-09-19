package com.birdeye.chatterbox.dialogflow.keySpace;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("session")
@Getter
@Setter
@AllArgsConstructor
public class Session
{
    @Id
    private String sessionId;

    private Long businessId;
}
