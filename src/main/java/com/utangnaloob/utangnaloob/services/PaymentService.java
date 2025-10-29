package com.utangnaloob.utangnaloob.services;

import com.utangnaloob.utangnaloob.dtos.PaymentRequestDTO;
import com.utangnaloob.utangnaloob.dtos.PaymentResponseDTO;
import com.utangnaloob.utangnaloob.exceptions.DebtNotFoundException;
import com.utangnaloob.utangnaloob.exceptions.InvalidPaymentException;
import com.utangnaloob.utangnaloob.exceptions.PaymentNotFoundException;
import com.utangnaloob.utangnaloob.mappers.PaymentMapper;
import com.utangnaloob.utangnaloob.models.Debt;
import com.utangnaloob.utangnaloob.models.DebtStatus;
import com.utangnaloob.utangnaloob.models.Payment;
import com.utangnaloob.utangnaloob.repositories.DebtRepository;
import com.utangnaloob.utangnaloob.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final DebtRepository debtRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, DebtRepository debtRepository) {
        this.paymentRepository = paymentRepository;
        this.debtRepository = debtRepository;
    }

    public List<PaymentResponseDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(PaymentMapper::toResponseDto)
                .toList();
    }

    public PaymentResponseDTO createPayment(PaymentRequestDTO requestDTO) {
        Debt debt = debtRepository.findById(requestDTO.getDebtId())
                .orElseThrow(() -> new DebtNotFoundException("Debt not found."));

        if (requestDTO.getPaymentAmount().compareTo(debt.getCurrentBalance()) > 0) {
            throw new InvalidPaymentException("Payment exceeds remaining balance.");
        }

        Payment payment = PaymentMapper.fromRequestDto(requestDTO);
        debt.addPayment(payment);

        BigDecimal currentBalance = debt.getCurrentBalance();

        DebtStatus debtStatus = currentBalance.compareTo(BigDecimal.ZERO) == 0
                ? DebtStatus.PAID_IN_FULL
                : DebtStatus.PARTIALLY_PAID;

        payment.setDebtStatusAtPayment(debtStatus);
        payment.setBalanceAfterPayment(currentBalance);

        Payment createdPayment = paymentRepository.saveAndFlush(payment);

        debt.setStatus(debtStatus);
        debtRepository.save(debt);

        return PaymentMapper.toResponseDto(createdPayment);
    }

    public PaymentResponseDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found."));

        return PaymentMapper.toResponseDto(payment);
    }
}
