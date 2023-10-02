package com.idorasi.profilematcher.dto;

import java.util.Map;

public record InventoryItemAddDto(Map<String, Integer> items,
                                  int addCash,
                                  int removeCash,
                                  int addCoins,
                                  int removeCoins) {

}
