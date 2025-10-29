package com.utangnaloob.utangnaloob.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Debtor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "debtor_id_seq_generator")
    @SequenceGenerator(
            name = "debtor_id_seq_generator",
            sequenceName = "debtor_id_sequence"
    )
    private Long id;

    private String name;

    @Column(nullable = true)
    private String email;

    @NotNull
    @Column(length = 20, nullable = false)
    private String contactNumber;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "debtor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Debt> debts = new HashSet<>();

    public void addDebt(Debt debt) {
        this.debts.add(debt);
        debt.setDebtor(this);
    }

    public void removeDebt(Debt debt) {
        this.debts.remove(debt);
        debt.setDebtor(this);
    }

    public Long getId() {
        return id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Debt> getDebts() {
        return debts;
    }

    public void setDebts(Set<Debt> debts) {
        this.debts = debts;
    }
}
