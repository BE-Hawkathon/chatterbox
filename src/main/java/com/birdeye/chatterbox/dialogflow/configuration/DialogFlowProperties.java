package com.birdeye.chatterbox.dialogflow.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("spring.dialogflow")
public class DialogFlowProperties
{
    private String projectId;

    private String languageCode;
}
