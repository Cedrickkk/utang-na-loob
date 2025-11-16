package com.utangnaloob.utangnaloob.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class DebtItemRequestDTO {
    @NotNull(message = "Item ID is required for a line item.")
    private Long itemId;

    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Quantity must be at least 1.")
    private Integer quantity;

    public DebtItemRequestDTO() {
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
