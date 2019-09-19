package com.birdeye.chatterbox.dialogflow.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@Configuration
@EnableMapRepositories({"com.birdeye.chatterbox.dialogflow"})
@EnableConfigurationProperties(DialogFlowProperties.class)
public class DialogFlowConfiguration
{
    @Bean
    public DialogFlowProperties dialogFlowProperties()
    {
        return new DialogFlowProperties();
    }
}
