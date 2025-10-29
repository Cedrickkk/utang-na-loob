package com.utangnaloob.utangnaloob.mappers;

import com.utangnaloob.utangnaloob.dtos.DebtorRequestDTO;
import com.utangnaloob.utangnaloob.dtos.DebtorResponseDTO;
import com.utangnaloob.utangnaloob.models.Debtor;

import java.util.stream.Collectors;

public final class DebtorMapper {
    private DebtorMapper() {
    }

    public static Debtor fromRequestDto(DebtorRequestDTO debtorRequestDTO) {
        if (debtorRequestDTO == null) return null;

        Debtor debtor = new Debtor();
        debtor.setName(debtorRequestDTO.getName());
        debtor.setEmail(debtorRequestDTO.getEmail());
        debtor.setContactNumber(debtorRequestDTO.getContactNumber());
        debtor.setAddress(debtorRequestDTO.getAddress());

        return debtor;
    }

    public static DebtorResponseDTO toResponseDto(Debtor debtor) {
        if (debtor == null) return null;

        DebtorResponseDTO responseDTO = new DebtorResponseDTO();
        responseDTO.setId(debtor.getId());
        responseDTO.setName(debtor.getName());
        responseDTO.setEmail(debtor.getEmail());
        responseDTO.setContactNumber(debtor.getContactNumber());
        responseDTO.setAddress(debtor.getAddress());

        if (debtor.getDebts() != null) {
            responseDTO.setDebts(debtor.getDebts()
                    .stream()
                    .map(DebtMapper::toSummaryResponseDto)
                    .collect(Collectors.toSet()));
        }

        return responseDTO;
    }
}
