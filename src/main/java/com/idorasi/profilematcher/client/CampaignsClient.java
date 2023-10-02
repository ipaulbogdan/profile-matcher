package com.idorasi.profilematcher.client;

import com.idorasi.profilematcher.config.CampaignsApiConfig;
import com.idorasi.profilematcher.dto.CampaignsDto;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class CampaignsClient {

    private CampaignsApiConfig campaignsApiConfig;
    private RestTemplate campaignsRestTemplate;

    public List<CampaignsDto> retrieveAllCampaigns() {
        var campaignsDtos = campaignsRestTemplate.getForObject(campaignsApiConfig.getCampaigns(), CampaignsDto[].class);

        if(campaignsDtos != null && campaignsDtos.length > 0) {
            return Arrays.stream(campaignsDtos).toList();
        }

        return Collections.emptyList();
    }
}
