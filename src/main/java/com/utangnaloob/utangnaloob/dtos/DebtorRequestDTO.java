package com.utangnaloob.utangnaloob.dtos;

import com.utangnaloob.utangnaloob.models.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class DebtorRequestDTO {
    @NotBlank(message = "Debtor name cannot be empty.")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters long.")
    private String name;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email should be valid.")
    private String email;

    @Valid
    @NotNull(message = "Address details are required.")
    private Address address;

    @NotBlank(message = "Contact number is required.")
    @Pattern(regexp = "^(09|\\+639)\\d{9}$", message = "Contact number must be an 11-digit mobile number (e.g., 09xxxxxxxxx or +639xxxxxxxxx).")
    private String contactNumber;

    public DebtorRequestDTO() {
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
}
