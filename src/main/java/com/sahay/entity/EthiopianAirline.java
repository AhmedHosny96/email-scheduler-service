package com.sahay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EthiopianAirline {

    @Id
    @Column(name = "requestid")
    private Long id;
    @Column(name = "wallettransactionid")
    private String walletReferenceId;
    @Column(name = "Amount")
    private Double amount;
    @Column(name = "pnr")
    private String pnr;
    @Column(name = "Currency")
    private String currency;
    @Column(name = "datecreated")
    private LocalDateTime dateCreated;
    @Column(name = "payermobile")
    private String customerPhoneNumber;
}
