package com.utangnaloob.utangnaloob.mappers;

import com.utangnaloob.utangnaloob.dtos.ItemRequestDTO;
import com.utangnaloob.utangnaloob.dtos.ItemResponseDTO;
import com.utangnaloob.utangnaloob.models.Item;

public class ItemMapper {
    public static ItemResponseDTO toDto(Item item) {
        if (item == null) return null;

        return new ItemResponseDTO(
                item.getId(),
                item.getName(),
                item.getPrice(),
                item.getCreatedAt(),
                item.getUpdatedAt());
    }

    public static Item fromDto(ItemRequestDTO itemRequestDTO) {
        if (itemRequestDTO == null) return null;

        Item item = new Item();
        item.setName(itemRequestDTO.getName());
        item.setPrice(itemRequestDTO.getPrice());
        return item;
    }
}
