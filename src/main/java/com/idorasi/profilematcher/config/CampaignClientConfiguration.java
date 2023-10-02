package com.idorasi.profilematcher.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@AllArgsConstructor
public class CampaignClientConfiguration {

    private CampaignsApiConfig campaignsApiConfig;

    @Bean
    public RestTemplate campaignsRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.rootUri(campaignsApiConfig.getBaseUrl()).build();
    }

}
