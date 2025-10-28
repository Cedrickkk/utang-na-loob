package com.utangnaloob.utangnaloob.services;

import com.utangnaloob.utangnaloob.dtos.ItemRequestDTO;
import com.utangnaloob.utangnaloob.dtos.ItemResponseDTO;
import com.utangnaloob.utangnaloob.exceptions.ItemNotFoundException;
import com.utangnaloob.utangnaloob.mappers.ItemMapper;
import com.utangnaloob.utangnaloob.models.Item;
import com.utangnaloob.utangnaloob.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemResponseDTO createItem(ItemRequestDTO itemRequestDTO) {
        Item item = itemRepository.saveAndFlush(ItemMapper.fromDto(itemRequestDTO));
        return ItemMapper.toDto(item);
    }

    public List<ItemResponseDTO> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemMapper::toDto)
                .toList();
    }

    public ItemResponseDTO getItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found."));
        return ItemMapper.toDto(item);
    }

    public ItemResponseDTO updateItemById(Long id, ItemRequestDTO itemRequestDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found."));

        item.setName(itemRequestDTO.getName());
        item.setPrice(itemRequestDTO.getPrice());

        Item updatedItem = itemRepository.save(item);

        return ItemMapper.toDto(updatedItem);
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
