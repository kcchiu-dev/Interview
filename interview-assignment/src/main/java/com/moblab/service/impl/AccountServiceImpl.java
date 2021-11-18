package com.moblab.service.impl;

import com.moblab.domain.entity.AccountEntity;
import com.moblab.domain.repo.AccountRepository;
import com.moblab.domain.repo.ActivityRepository;
import com.moblab.service.AccountService;
import com.moblab.shared.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {


    private final boolean DISABLE_KEYWORD_FALSE = false;
    private final String DISABLE_KEYWORD_Y = "y";
    private final String DISABLE_KEYWORD_N = "n";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Account getUserByUserName(String username) {
        Optional<AccountEntity> optionalAccount = accountRepository.findByUsername(username);
        Account account = new Account();
        if(optionalAccount.isPresent()){
            account = convertToDto(optionalAccount.get());
        }
        return account;
    }

    @Override
    public List<Account> fetchAllUser() {
        List<AccountEntity> list = accountRepository.findByDisableOrderByUsername(DISABLE_KEYWORD_FALSE);
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public int addUser(Account account) {
        String userId = UUID.randomUUID().toString();
        return accountRepository.addUser(account.getUsername(),userId, DISABLE_KEYWORD_N, LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public Object deleteUser(String userId) {
        boolean bResult = false;
        if(accountRepository.deleteUser(DISABLE_KEYWORD_Y, LocalDateTime.now(), userId) > 0){
            activityRepository.deleteListByUserId(userId);
            bResult = true;
        }
        return bResult;
    }


    private Account convertToDto(AccountEntity accountEntity) {
        Account account = modelMapper.map(accountEntity, Account.class);
        return account;
    }
}
