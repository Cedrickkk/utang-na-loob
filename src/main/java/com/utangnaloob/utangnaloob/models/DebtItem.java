package com.utangnaloob.utangnaloob.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;

@Entity
public class DebtItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "debt_item_id_seq_generator")
    @SequenceGenerator(
            name = "debt_item_id_seq_generator",
            sequenceName = "debt_item_id_sequence"
    )
    private Long id;

    @ManyToOne
    private Debt debt;

    @ManyToOne
    private Item item;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    @Column(nullable = false)
    private Integer quantity;

    @Formula("unit_price * quantity")
    private BigDecimal lineTotal;

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(BigDecimal lineTotal) {
        this.lineTotal = lineTotal;
    }
}
