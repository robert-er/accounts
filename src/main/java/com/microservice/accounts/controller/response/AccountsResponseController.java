package com.microservice.accounts.controller.response;

import com.microservice.accounts.dto.AccountDto;
import com.microservice.accounts.mapper.AccountMapper;
import com.microservice.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountsResponseController {

    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @GetMapping("/v1/accounts")
    public List<AccountDto> getAccounts(@RequestParam Long customerId) {
        return accountMapper.mapToAccountDtoList(accountService.findByCustomerId(customerId));
    }
}
