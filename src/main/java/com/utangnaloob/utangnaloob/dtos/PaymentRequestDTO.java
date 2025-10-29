package com.utangnaloob.utangnaloob.dtos;

import com.utangnaloob.utangnaloob.models.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentRequestDTO {
    @NotNull(message = "Debt ID is required to apply the payment.")
    private Long debtId;

    @NotNull(message = "Payment amount is required.")
    @DecimalMin(value = "1", message = "Payment must be greater than zero.")
    private BigDecimal paymentAmount;

    @NotNull(message = "Payment method is required.")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Payment date is required.")
    private LocalDateTime paymentDate;

    public PaymentRequestDTO() {
    }

    public Long getDebtId() {
        return debtId;
    }

    public void setDebtId(Long debtId) {
        this.debtId = debtId;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
