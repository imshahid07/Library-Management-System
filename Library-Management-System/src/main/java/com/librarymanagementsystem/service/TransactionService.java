package com.librarymanagementsystem.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.entity.Member;
import com.librarymanagementsystem.entity.Transaction;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.repository.MemberRepository;
import com.librarymanagementsystem.repository.TransactionRepository;

@Service
public class TransactionService {
	
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;
    
    public Transaction borrowBook(Long memberId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        if (book.getQuantity() <= 0) throw new RuntimeException("Book not available");

        Member member = memberRepository.findById(memberId).orElseThrow();

        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        Transaction txn = new Transaction();
        txn.setBook(book);
        txn.setMember(member);
        txn.setBorrowDate(LocalDate.now());

        return transactionRepository.save(txn);
    }

    public Transaction returnBook(Long txnId) {
        Transaction txn = transactionRepository.findById(txnId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + txnId));

        if (txn.getReturnDate() != null) {
            throw new RuntimeException("Book already returned.");
        }

        Book book = txn.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);

        txn.setReturnDate(LocalDate.now());
        return transactionRepository.save(txn);
    }
}
