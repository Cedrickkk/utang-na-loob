package com.utangnaloob.utangnaloob.mappers;

import com.utangnaloob.utangnaloob.dtos.DebtRequestDTO;
import com.utangnaloob.utangnaloob.dtos.DebtResponseDTO;
import com.utangnaloob.utangnaloob.dtos.DebtSummaryResponseDTO;
import com.utangnaloob.utangnaloob.models.Debt;

import java.math.BigDecimal;
import java.util.Objects;

public final class DebtMapper {
    public static Debt fromRequestDto(DebtRequestDTO requestDTO) {
        return new Debt();
    }

    public static DebtResponseDTO toResponseDto(Debt debt) {
        if (debt == null) return null;

        DebtResponseDTO debtResponseDTO = new DebtResponseDTO();
        debtResponseDTO.setId(debt.getId());
        debtResponseDTO.setDebtorName(debt.getDebtor().getName());
        debtResponseDTO.setDebtStatus(debt.getStatus());
        BigDecimal originalAmount = Objects.requireNonNullElse(debt.getOriginalAmount(), BigDecimal.ZERO);
        debtResponseDTO.setOriginalAmount(originalAmount);
        debtResponseDTO.setCurrentBalance(debt.getCurrentBalance());
        debtResponseDTO.setCreatedAt(debt.getCreatedAt());

        return debtResponseDTO;
    }

    public static DebtSummaryResponseDTO toSummaryResponseDto(Debt debt) {
        if (debt == null) return null;

        DebtSummaryResponseDTO responseDTO = new DebtSummaryResponseDTO();
        responseDTO.setId(debt.getId());
        responseDTO.setDebtStatus(debt.getStatus());
        responseDTO.setCurrentBalance(debt.getCurrentBalance());
        responseDTO.setOriginalAmount(debt.getOriginalAmount());

        return responseDTO;
    }
}
