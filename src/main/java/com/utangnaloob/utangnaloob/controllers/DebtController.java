package com.utangnaloob.utangnaloob.controllers;

import com.utangnaloob.utangnaloob.dtos.DebtRequestDTO;
import com.utangnaloob.utangnaloob.dtos.DebtResponseDTO;
import com.utangnaloob.utangnaloob.models.SuccessResponse;
import com.utangnaloob.utangnaloob.services.DebtService;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DebtController {
    private final DebtService debtService;

    @Autowired
    public DebtController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping("/debts")
    public ResponseEntity<SuccessResponse<List<DebtResponseDTO>>> getAllDebts() {
        List<DebtResponseDTO> debts = debtService.getAllDebts();
        SuccessResponse<List<DebtResponseDTO>> response = new SuccessResponse<>(
                HttpStatus.OK,
                "Debts retrieved successfully.",
                debts
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("/debts")
    public ResponseEntity<SuccessResponse<DebtResponseDTO>> createDebt(
            @Validated({Default.class})
            @RequestBody DebtRequestDTO requestDTO) {
        DebtResponseDTO debt = debtService.createDebt(requestDTO);
        SuccessResponse<DebtResponseDTO> response = new SuccessResponse<>(
                HttpStatus.CREATED,
                "Debts retrieved successfully.",
                debt
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/debts/{id}")
    public ResponseEntity<SuccessResponse<DebtResponseDTO>> getDebtById(@PathVariable Long id) {
        DebtResponseDTO debt = debtService.getDebtById(id);
        SuccessResponse<DebtResponseDTO> response = new SuccessResponse<>(
                HttpStatus.FOUND,
                "Debt found successfully.",
                debt
        );

        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

}
