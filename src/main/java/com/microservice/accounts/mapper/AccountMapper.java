package com.microservice.accounts.mapper;

import com.microservice.accounts.domain.Account;
import com.microservice.accounts.dto.AccountDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    private AccountDto mapToAccountDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .nrb(account.getNrb())
                .currency(account.getCurrency())
                .availableFunds(account.getAvailableFunds())
                .build();
    }

    public List<AccountDto> mapToAccountDtoList(List<Account> accountList) {
        return accountList.stream().map(this::mapToAccountDto).collect(Collectors.toList());
    }
}
