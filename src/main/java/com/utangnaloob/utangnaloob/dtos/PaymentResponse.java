package com.utangnaloob.utangnaloob.dtos;

import com.utangnaloob.utangnaloob.models.DebtStatus;
import com.utangnaloob.utangnaloob.models.PaymentMethod;
import com.utangnaloob.utangnaloob.models.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponseDTO {
    private Long id;
    private Long debtId;
    private String debtorName;
    private BigDecimal amount;
    private PaymentMethod method;
    private LocalDateTime date;
    private PaymentStatus status;
    private BigDecimal newDebtBalance;
    private DebtStatus debtStatus;

    public PaymentResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDebtId() {
        return debtId;
    }

    public void setDebtId(Long debtId) {
        this.debtId = debtId;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getNewDebtBalance() {
        return newDebtBalance;
    }

    public void setNewDebtBalance(BigDecimal newDebtBalance) {
        this.newDebtBalance = newDebtBalance;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public DebtStatus getDebtStatus() {
        return debtStatus;
    }

    public void setDebtStatus(DebtStatus debtStatus) {
        this.debtStatus = debtStatus;
    }
}
