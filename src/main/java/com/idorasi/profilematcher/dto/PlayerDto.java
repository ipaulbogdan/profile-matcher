package com.idorasi.profilematcher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.idorasi.profilematcher.model.Clan;
import com.idorasi.profilematcher.model.Device;
import com.idorasi.profilematcher.model.Inventory;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;

@Builder
public record PlayerDto(@JsonProperty("player_id") UUID playerId,
                        String credential,
                        LocalDateTime created,
                        LocalDateTime modified,
                        @JsonProperty("last_session") LocalDateTime lastSession,
                        @JsonProperty("total_spent") BigDecimal totalSpent,
                        @JsonProperty("total_refund") BigDecimal totalRefund,
                        @JsonProperty("total_transactions") int totalTransaction,
                        @JsonProperty("last_purchase") LocalDateTime lastPurchase,
                        Set<Device> devices,
                        int level,
                        int xp,
                        @JsonProperty("total_playtime") int totalPlaytime,
                        String country,
                        String language,
                        LocalDate birthdate,
                        @JsonProperty("active_campaigns") Set<String> activeCampaigns,
                        String gender,
                        Inventory inventory,
                        Clan clan,
                        @JsonProperty("_customField") String customField) {
}
