package com.utangnaloob.utangnaloob.dtos;

import com.utangnaloob.utangnaloob.models.PaymentMethod;
import com.utangnaloob.utangnaloob.models.PaymentStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentRequestDTO {
    @NotNull(message = "Debt ID is required to apply the payment.")
    private Long debtId;

    @NotNull(message = "Payment amount is required.")
    @DecimalMin(value = "1", message = "Payment must be greater than zero.")
    private BigDecimal amount;

    @NotNull(message = "Payment method is required.")
    private PaymentMethod method;

    @NotNull(message = "Payment date is required.")
    private LocalDateTime date;

    private PaymentStatus status;

    public PaymentRequestDTO() {
    }

    public Long getDebtId() {
        return debtId;
    }

    public void setDebtId(Long debtId) {
        this.debtId = debtId;
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
}
