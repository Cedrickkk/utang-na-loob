package com.utangnaloob.utangnaloob.controllers;

import com.utangnaloob.utangnaloob.dtos.ItemRequestDTO;
import com.utangnaloob.utangnaloob.dtos.ItemResponseDTO;
import com.utangnaloob.utangnaloob.models.SuccessResponse;
import com.utangnaloob.utangnaloob.services.ItemService;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public ResponseEntity<SuccessResponse<ItemResponseDTO>> createItem(
            @Validated({Default.class})
            @RequestBody ItemRequestDTO requestDTO) {
        ItemResponseDTO responseDTO = itemService.createItem(requestDTO);
        SuccessResponse<ItemResponseDTO> response = new SuccessResponse<>(
                HttpStatus.CREATED,
                "Item created successfully.",
                responseDTO
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/items")
    public ResponseEntity<SuccessResponse<List<ItemResponseDTO>>> getAllItems() {
        List<ItemResponseDTO> items = itemService.getAllItems();
        SuccessResponse<List<ItemResponseDTO>> response = new SuccessResponse<>(
                HttpStatus.OK,
                "Items retrieved successfully.",
                items
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<SuccessResponse<ItemResponseDTO>> getItemByid(@PathVariable Long id) {
        ItemResponseDTO itemResponseDTO = itemService.getItemById(id);
        SuccessResponse<ItemResponseDTO> response = new SuccessResponse<>(
                HttpStatus.FOUND,
                "Item found successfully.",
                itemResponseDTO
        );

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<SuccessResponse<ItemResponseDTO>> updateItemById(
            @PathVariable Long id,
            @Validated({Default.class})
            @RequestBody ItemRequestDTO requestDTO) {
        ItemResponseDTO updatedItem = itemService.updateItemById(id, requestDTO);

        SuccessResponse<ItemResponseDTO> response = new SuccessResponse<>(
                HttpStatus.OK,
                "Item updated successfully.",
                updatedItem
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        
        return ResponseEntity.noContent().build();
    }
}
