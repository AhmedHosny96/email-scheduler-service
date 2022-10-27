package com.sahay.repository;

import com.sahay.entity.EthiopianAirline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EthiopianAirlineRepository extends JpaRepository<EthiopianAirline , Long> {


    @Query(value = "" +
            "SELECT [RequestId] , [WalletTransactionId], [Amount] , [PNR] ,[Currency],[DateCreated] , [PayerMobile] " +
            "FROM [aggregator].[dbo].[EthiopianAirline]" +
            "WHERE DateCreated < GETDATE() AND DateCreated > DATEADD(MINUTE ,-30 ,GETDATE()) " +
            "AND PaymentConfirmResponse in ('0000' , '0002') AND WalletTransactionId != 'NA' " +
            "ORDER BY DateCreated DESC"
            , nativeQuery = true)
    List<EthiopianAirline> findEthiopianAirlinesLastTranx();
}
