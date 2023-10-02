package com.idorasi.profilematcher.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "campaign-api")
public class CampaignsApiConfig {

    private String baseUrl;
    private String campaigns;
}
