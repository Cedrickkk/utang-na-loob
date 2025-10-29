package com.utangnaloob.utangnaloob.dtos;

import com.utangnaloob.utangnaloob.models.DebtStatus;

import java.math.BigDecimal;

public class DebtSummaryResponseDTO {
    private Long id;
    private BigDecimal originalAmount;
    private BigDecimal currentBalance;
    private DebtStatus debtStatus;

    public DebtSummaryResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
