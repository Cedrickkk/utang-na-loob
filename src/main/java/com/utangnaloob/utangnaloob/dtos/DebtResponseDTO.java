package com.utangnaloob.utangnaloob.dtos;

import com.utangnaloob.utangnaloob.models.DebtStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DebtResponseDTO {
    private Long id;
    private String debtorName;
    private BigDecimal originalAmount;
    private BigDecimal currentBalance;
    private DebtStatus debtStatus;
    private LocalDateTime createdAt;

    public DebtResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public DebtStatus getDebtStatus() {
        return debtStatus;
    }

    public void setDebtStatus(DebtStatus debtStatus) {
        this.debtStatus = debtStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
