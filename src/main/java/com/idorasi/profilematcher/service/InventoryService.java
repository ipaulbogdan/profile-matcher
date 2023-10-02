package com.idorasi.profilematcher.service;

import com.idorasi.profilematcher.dto.InventoryItemAddDto;
import com.idorasi.profilematcher.model.Inventory;
import com.idorasi.profilematcher.model.InventoryItem;
import com.idorasi.profilematcher.repository.InventoryRepository;
import com.idorasi.profilematcher.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryService {

    private InventoryRepository inventoryRepository;
    private ItemRepository itemRepository;

    @Transactional
    public Inventory addItems(long inventoryId, InventoryItemAddDto itemAddDto) {
        var itemsMap = itemAddDto.items();
        var items = itemRepository.findAllByNameIn(itemsMap.keySet().stream().toList());
        var inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Unable to find inventory with id " + inventoryId));

        inventory.setCash(inventory.getCash() - itemAddDto.removeCash() + itemAddDto.addCash());
        inventory.setCoins(inventory.getCoins() - itemAddDto.removeCoins() + itemAddDto.addCoins());

        var inventoryItems = items.stream()
                .map(item -> new InventoryItem().setItem(item).setCount(itemsMap.get(item.getName())))
                .collect(Collectors.toSet());

        return inventoryRepository.save(inventory.setItems(inventoryItems));
    }
}
