package com.utangnaloob.utangnaloob.controllers;

import com.utangnaloob.utangnaloob.dtos.DebtorRequestDTO;
import com.utangnaloob.utangnaloob.dtos.DebtorResponseDTO;
import com.utangnaloob.utangnaloob.models.SuccessResponse;
import com.utangnaloob.utangnaloob.services.DebtorService;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DebtorController {
    private final DebtorService debtorService;

    @Autowired
    public DebtorController(DebtorService debtorService) {
        this.debtorService = debtorService;
    }

    @GetMapping("/debtors")
    public ResponseEntity<SuccessResponse<List<DebtorResponseDTO>>> getAllDebtors() {
        List<DebtorResponseDTO> debtors = debtorService.getAllDebtors();

        SuccessResponse<List<DebtorResponseDTO>> response = new SuccessResponse<>(
                HttpStatus.OK,
                "Debtors retrieved successfully.",
                debtors
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("/debtors")
    public ResponseEntity<SuccessResponse<DebtorResponseDTO>> createDebtor(
            @Validated({Default.class})
            @RequestBody DebtorRequestDTO requestDTO) {
        DebtorResponseDTO debtor = debtorService.createDebtor(requestDTO);

        SuccessResponse<DebtorResponseDTO> response = new SuccessResponse<>(
                HttpStatus.CREATED,
                "Debtor created successfully.",
                debtor
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/debtors/{id}")
    public ResponseEntity<SuccessResponse<DebtorResponseDTO>> getDebtorById(@PathVariable Long id) {
        DebtorResponseDTO debtor = debtorService.getDebtorById(id);

        SuccessResponse<DebtorResponseDTO> response = new SuccessResponse<>(
                HttpStatus.FOUND,
                "Debtor found successfully.",
                debtor
        );

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(response);
    }

    @PutMapping("/debtors/{id}")
    public ResponseEntity<SuccessResponse<DebtorResponseDTO>> updateDebtorById(
            @PathVariable Long id,
            @Validated({Default.class})
            @RequestBody DebtorRequestDTO requestDTO
    ) {
        DebtorResponseDTO updatedDebtor = debtorService.updateDebtorById(id, requestDTO);

        SuccessResponse<DebtorResponseDTO> response = new SuccessResponse<>(
                HttpStatus.OK,
                "Debtor updated successfully.",
                updatedDebtor
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }


    @DeleteMapping("/debtors/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id) {
        debtorService.deleteDebtorById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
