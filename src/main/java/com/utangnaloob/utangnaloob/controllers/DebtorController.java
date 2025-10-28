package com.utangnaloob.utangnaloob.controllers;

import com.utangnaloob.utangnaloob.models.Debtor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DebtorController {
    @PostMapping("/debtors")
    public ResponseEntity<Debtor> store() {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Debtor());
    }
}
