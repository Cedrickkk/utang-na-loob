package com.utangnaloob.utangnaloob.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_seq_generator")
    @SequenceGenerator(
            name = "payment_id_seq_generator",
            sequenceName = "payment_id_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "debt_id", nullable = false)
    private Debt debt;

    private BigDecimal paymentAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DebtStatus debtStatusAtPayment;

    @Column(nullable = false)
    private BigDecimal balanceAfterPayment;

    @CreationTimestamp
    private LocalDateTime paymentDate;

    public Long getId() {
        return id;
    }

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public BigDecimal getBalanceAfterPayment() {
        return balanceAfterPayment;
    }

    public void setBalanceAfterPayment(BigDecimal balanceAfterPayment) {
        this.balanceAfterPayment = balanceAfterPayment;
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

    public DebtStatus getDebtStatusAtPayment() {
        return debtStatusAtPayment;
    }

    public void setDebtStatusAtPayment(DebtStatus debtStatusAtPayment) {
        this.debtStatusAtPayment = debtStatusAtPayment;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
