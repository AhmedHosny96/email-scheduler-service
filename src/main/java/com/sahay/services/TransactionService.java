//package com.sahay.services;
//
//
//import com.sahay.entity.Transaction;
//import com.sahay.repository.TransactionRepository;
//import com.sahay.util.CsvGenerator;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class TransactionService {
//
//    private final TransactionRepository transactionRepository;
//
//    private final CsvGenerator csvGenerator;
//
//    // get ethiopian airlines tickets for the past 30 minutes
//
//    public ByteArrayInputStream getLastTransactions() {
//
//        List<Transaction> lastTransactions = transactionRepository.findLastTransactions("ETAIR");
//
//        ByteArrayInputStream exportToCsv = csvGenerator.exportToCsv(lastTransactions,
//               );
//        return exportToCsv;
//    }
//}
