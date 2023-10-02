package com.idorasi.profilematcher.controller;

import com.idorasi.profilematcher.dto.InventoryItemAddDto;
import com.idorasi.profilematcher.model.Inventory;
import com.idorasi.profilematcher.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/inventories")
public class InventoryController {

    private InventoryService inventoryService;

    @PostMapping("/{inventoryId}")
    public Inventory addItems(@PathVariable long inventoryId, @RequestBody InventoryItemAddDto items) {
        return inventoryService.addItems(inventoryId, items);
    }
}
