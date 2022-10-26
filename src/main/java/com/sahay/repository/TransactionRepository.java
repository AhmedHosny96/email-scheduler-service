//package com.sahay.repository;
//
//import com.sahay.entity.Transaction;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface TransactionRepository extends JpaRepository<Transaction , Long> {
//
//    @Query(
//            value = "SELECT [Id] , [TransactionId]  ,[Account],[Amount] ,[Narration] , [TranDate] , [TransactionReqType]  FROM [mobile_banking].[dbo].[Transaction] " +
//                    "WHERE  TransactionReqType = ?1 AND Narration LIKE '%Transfer%' AND TranDate < GETDATE() AND TranDate > DATEADD (HOUR , -1 , GETDATE() ) ORDER BY TranDate DESC"
//            ,
//            nativeQuery = true
//    )
//    List<Transaction> findLastTransactions( String transactionReqType);
//
//
//}
