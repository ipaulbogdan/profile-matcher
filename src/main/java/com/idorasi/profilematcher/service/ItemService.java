package com.idorasi.profilematcher.service;

import com.idorasi.profilematcher.dto.ItemCreateDto;
import com.idorasi.profilematcher.model.Item;
import com.idorasi.profilematcher.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public Item createItem(ItemCreateDto itemCreateDto) {
        var item = new Item().setName(itemCreateDto.name());

        return itemRepository.save(item);
    }
}
