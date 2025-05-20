package com.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanagementsystem.entity.Transaction;
import com.librarymanagementsystem.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/borrow")
    public ResponseEntity<Transaction> borrowBook(
        @RequestParam("memberId") Long memberId,
        @RequestParam("bookId") Long bookId
    ) {
        return ResponseEntity.ok(transactionService.borrowBook(memberId, bookId));
    }


    @PostMapping("/return")
    public ResponseEntity<Transaction> returnBook(@RequestParam("txnId") Long txnId) {
        return ResponseEntity.ok(transactionService.returnBook(txnId));
    }
}
