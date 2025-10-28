package com.utangnaloob.utangnaloob.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq_generator")
    @SequenceGenerator(
            name = "item_id_seq_generator",
            sequenceName = "item_id_sequence"
    )
    private Long id;

    private String name;

    private BigDecimal price;

    @OneToMany(mappedBy = "item")
    private Set<DebtItem> debtItems = new HashSet<>();

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<DebtItem> getDebtItems() {
        return debtItems;
    }

    public void setDebtItems(Set<DebtItem> debtItems) {
        this.debtItems = debtItems;
    }
}
