package com.microservice.accounts.controller.response;

import com.microservice.accounts.dto.AccountDto;
import com.microservice.accounts.mapper.AccountMapper;
import com.microservice.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountsResponseController {

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @GetMapping("/v1/accounts")
    public List<AccountDto> getAccounts(@RequestParam Long customerId) {
        if (!allowGetAccounts) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "GET accounts is disabled.");
        }
        return accountMapper.mapToAccountDtoList(accountService.findByCustomerId(customerId));
    }
}
