package com.utangnaloob.utangnaloob.controllers;

import com.utangnaloob.utangnaloob.dtos.PaymentRequestDTO;
import com.utangnaloob.utangnaloob.dtos.PaymentResponseDTO;
import com.utangnaloob.utangnaloob.models.SuccessResponse;
import com.utangnaloob.utangnaloob.services.PaymentService;
import jakarta.validation.groups.Default;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public ResponseEntity<SuccessResponse<List<PaymentResponseDTO>>> getAllPayments() {
        List<PaymentResponseDTO> payments = paymentService.getAllPayments();
        SuccessResponse<List<PaymentResponseDTO>> response = new SuccessResponse<>(
                HttpStatus.OK,
                "Payments retrieved successfully.",
                payments
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("/payments")
    public ResponseEntity<SuccessResponse<PaymentResponseDTO>> createPayment(
            @Validated({Default.class})
            @RequestBody PaymentRequestDTO requestDTO) {
        PaymentResponseDTO payment = paymentService.createPayment(requestDTO);
        SuccessResponse<PaymentResponseDTO> response = new SuccessResponse<>(
                HttpStatus.CREATED,
                "Payment created successfully.",
                payment
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<SuccessResponse<PaymentResponseDTO>> getPaymentById(@PathVariable Long id) {
        PaymentResponseDTO payment = paymentService.getPaymentById(id);
        SuccessResponse<PaymentResponseDTO> response = new SuccessResponse<>(
                HttpStatus.CREATED,
                "Payment found successfully.",
                payment
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
