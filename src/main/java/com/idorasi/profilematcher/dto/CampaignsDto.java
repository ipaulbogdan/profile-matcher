package com.idorasi.profilematcher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CampaignsDto {

    private boolean enabled;
    private String name;
    private String game;
    private double priority;

    @JsonProperty("start_date")
    private Instant startDate;

    @JsonProperty("end_date")
    private Instant endDate;

    @JsonProperty("last_updated")
    private Instant lastUpdated;

    private Matchers matchers;

    @Getter
    @AllArgsConstructor
    public static class Matchers {

        private LevelMatcher level;
        private DoesNotHave doesNotHave;
        private Has has;
    }

    @Getter
    @AllArgsConstructor
    public static class LevelMatcher {

        private int min;
        private int max;
    }

    @Getter
    @Setter
    public static class DoesNotHave {

        private Set<String> items;
    }

    @Getter
    @AllArgsConstructor
    public static class Has {

        private Set<String> country;
        private Set<String> items;
    }
}
