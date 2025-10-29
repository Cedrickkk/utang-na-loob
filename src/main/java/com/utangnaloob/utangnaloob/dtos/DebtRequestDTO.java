package com.utangnaloob.utangnaloob.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class DebtRequestDTO {
    @NotNull(message = "Debtor ID is required to create a debt.")
    private Long debtorId;

    @Valid
    @NotNull(message = "A debt must contain at least one item.")
    @Size(min = 1, message = "Debt must contain at least one item.")
    private Set<DebtItemRequestDTO> debtItems = new HashSet<>();

    public DebtRequestDTO() {
    }

    public Long getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(Long debtorId) {
        this.debtorId = debtorId;
    }

    public Set<DebtItemRequestDTO> getDebtItems() {
        return debtItems;
    }

    public void setDebtItems(Set<DebtItemRequestDTO> debtItems) {
        this.debtItems = debtItems;
    }
}
