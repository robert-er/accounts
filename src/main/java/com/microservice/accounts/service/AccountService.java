package com.microservice.accounts.service;

import com.microservice.accounts.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    List<Account> findByCustomerId(Long customerId);
}
