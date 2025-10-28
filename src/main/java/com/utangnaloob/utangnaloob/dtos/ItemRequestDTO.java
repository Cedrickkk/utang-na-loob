package com.utangnaloob.utangnaloob.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ItemRequestDTO {
    @NotBlank(message = "Item cannot be empty.")
    private String name;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    private BigDecimal price;

    public ItemRequestDTO() {
    }

    public ItemRequestDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public @NotBlank(message = "Item cannot be empty.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Item cannot be empty.") String name) {
        this.name = name;
    }

    public @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price cannot be null")
                         @DecimalMin(value = "0.01", message = "Price must be greater than zero")
                         BigDecimal price) {
        this.price = price;
    }
}
