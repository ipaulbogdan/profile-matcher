package com.idorasi.profilematcher.controller;

import com.idorasi.profilematcher.dto.ItemCreateDto;
import com.idorasi.profilematcher.model.Item;
import com.idorasi.profilematcher.service.ItemService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/items")
public class ItemController {

    private ItemService itemService;

    @PostMapping
    public Item postItem(@RequestBody @Valid ItemCreateDto itemCreateDto) {
        return itemService.createItem(itemCreateDto);
    }

}
