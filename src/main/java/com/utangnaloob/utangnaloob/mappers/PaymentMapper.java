package com.utangnaloob.utangnaloob.mappers;

import com.utangnaloob.utangnaloob.dtos.PaymentRequestDTO;
import com.utangnaloob.utangnaloob.dtos.PaymentResponseDTO;
import com.utangnaloob.utangnaloob.models.Payment;

public final class PaymentMapper {
    public static Payment fromRequestDto(PaymentRequestDTO requestDTO) {
        if (requestDTO == null) return null;

        Payment payment = new Payment();
        payment.setPaymentAmount(requestDTO.getPaymentAmount());
        payment.setPaymentMethod(requestDTO.getPaymentMethod());
        payment.setPaymentDate(requestDTO.getPaymentDate());

        return payment;
    }

    public static PaymentResponseDTO toResponseDto(Payment payment) {
        if (payment == null) return null;

        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        responseDTO.setId(payment.getId());
        responseDTO.setDebtId(payment.getDebt().getId());
        responseDTO.setPaymentAmount(payment.getPaymentAmount());
        responseDTO.setPaymentMethod(payment.getPaymentMethod());
        responseDTO.setPaymentDate(payment.getPaymentDate());
        responseDTO.setDebtorName(payment.getDebt()
                .getDebtor()
                .getName());

        responseDTO.setNewDebtBalance(payment.getBalanceAfterPayment());
        responseDTO.setDebtStatus(payment.getDebtStatusAtPayment());

        return responseDTO;
    }
}
