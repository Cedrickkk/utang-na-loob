package com.utangnaloob.utangnaloob.dtos;

import com.utangnaloob.utangnaloob.models.Address;

import java.util.HashSet;
import java.util.Set;

public class DebtorResponse {
    private Long id;
    private String name;
    private String email;
    private String contactNumber;
    private Address address;
    private Set<DebtSummaryResponseDTO> debts = new HashSet<>();

    public DebtorResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<DebtSummaryResponseDTO> getDebts() {
        return debts;
    }

    public void setDebts(Set<DebtSummaryResponseDTO> debts) {
        this.debts = debts;
    }
}
