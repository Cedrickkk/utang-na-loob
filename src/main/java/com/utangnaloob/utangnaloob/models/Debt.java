package com.utangnaloob.utangnaloob.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "debt_id_seq_generator")
    @SequenceGenerator(
            name = "debt_id_seq_generator",
            sequenceName = "debt_id_sequence"
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "debtor_id", nullable = false)
    private Debtor debtor;

    @Formula("SELECT COALESCE(SUM(di.line_total), 0) FROM DebtItem di WHERE di.debt_id = id")
    private BigDecimal originalAmount;

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DebtItem> debtItems = new HashSet<>();

    @OneToMany(mappedBy = "debt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Payment> payments = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DebtStatus status = DebtStatus.OUTSTANDING;


    public void addDebtItem(DebtItem debtItem) {
        this.debtItems.add(debtItem);
        debtItem.setDebt(this);
    }

    public void removeDebtItem(DebtItem debtItem) {
        this.debtItems.remove(debtItem);
        debtItem.setDebt(null);
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
        payment.setDebt(this);
    }

    public void removePayment(Payment payment) {
        this.payments.remove(payment);
        payment.setDebt(null);
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public void setDebtor(Debtor debtor) {
        this.debtor = debtor;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Set<DebtItem> getDebtItems() {
        return debtItems;
    }

    public void setDebtItems(Set<DebtItem> debtItems) {
        this.debtItems = debtItems;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public DebtStatus getStatus() {
        return status;
    }

    public void setStatus(DebtStatus status) {
        this.status = status;
    }
}
