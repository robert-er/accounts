package com.microservice.accounts.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nrb;
    private String currency;
    private BigDecimal availableFunds;

    private Long customerId;

    @Builder
    public Account(String nrb, String currency, BigDecimal availableFunds, Long customerId) {
        this.nrb = nrb;
        this.currency = currency;
        this.availableFunds = availableFunds;
        this.customerId = customerId;
    }
}
