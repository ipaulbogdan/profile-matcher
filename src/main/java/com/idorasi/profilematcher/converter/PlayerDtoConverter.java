package com.idorasi.profilematcher.converter;

import com.idorasi.profilematcher.dto.PlayerDto;
import com.idorasi.profilematcher.model.Player;
import java.util.Set;

public class PlayerDtoConverter {

    public static PlayerDto convertFromEntity(Player player) {
        return getBuilder(player)
                .build();
    }

    public static PlayerDto convertFromEntity(Player player, Set<String> campaigns) {
        return getBuilder(player)
                .activeCampaigns(campaigns)
                .build();

    }

    private static PlayerDto.PlayerDtoBuilder getBuilder(Player player) {
        return PlayerDto.builder()
                .playerId(player.getPlayerId())
                .credential(player.getCredential())
                .created(player.getCreated())
                .modified(player.getModified())
                .lastSession(player.getLastSession())
                .totalPlaytime(player.getTotalPlaytime())
                .totalRefund(player.getTotalRefund())
                .totalSpent(player.getTotalSpent())
                .totalTransaction(player.getTotalTransactions())
                .lastPurchase(player.getLastPurchase())
                .devices(player.getDevices())
                .level(player.getLevel())
                .xp(player.getXp())
                .country(player.getCountry())
                .language(player.getLanguage())
                .birthdate(player.getBirthdate())
                .gender(player.getGender())
                .inventory(player.getInventory())
                .clan(player.getClan())
                .customField(player.getCustomField());
    }
}
