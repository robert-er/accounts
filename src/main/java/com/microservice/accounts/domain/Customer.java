package com.microservice.accounts.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long customerId;

    @OneToMany(targetEntity = Account.class,
            mappedBy = "customerId",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Account> accounts = new ArrayList<>();

    @Builder
    public Customer(Long customerId) {
        this.customerId = customerId;
    }
}
