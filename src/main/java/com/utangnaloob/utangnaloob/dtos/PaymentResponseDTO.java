package com.utangnaloob.utangnaloob.dtos;

import com.utangnaloob.utangnaloob.models.DebtStatus;
import com.utangnaloob.utangnaloob.models.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponseDTO {
    private Long id;
    private Long debtId;
    private String debtorName;
    private BigDecimal paymentAmount;
    private PaymentMethod paymentMethod;
    private LocalDateTime paymentDate;

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

    public BigDecimal getNewDebtBalance() {
        return newDebtBalance;
    }

    public void setNewDebtBalance(BigDecimal newDebtBalance) {
        this.newDebtBalance = newDebtBalance;
    }

    public DebtStatus getDebtStatus() {
        return debtStatus;
    }

    public void setDebtStatus(DebtStatus debtStatus) {
        this.debtStatus = debtStatus;
    }
}
