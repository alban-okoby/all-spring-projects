package com.digitalsouag.cashcard.controller;

import com.digitalsouag.cashcard.entity.CashCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.beans.ConstructorProperties;

@RestController
public class CashCardController {
    @GetMapping("/cashcards/{id}")
    public ResponseEntity<CashCard> findById(@PathVariable Long id) {
        CashCard cashCard = new CashCard(); /* Not working code */
        return ResponseEntity.ok(cashCard);
    }
}
