package com.moblab.interviewassignment.Service.Impl;

import com.moblab.domain.entity.AccountEntity;
import com.moblab.domain.repo.AccountRepository;
import com.moblab.service.impl.AccountServiceImpl;
import com.moblab.shared.Account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.*;



@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {


    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;


    @Mock
    private ModelMapper modelMapper;
    @Mock
    private AccountEntity accountEntity;
    @Mock
    private Account account;




    @Test
    public void testGetUserByUserName() {
        BDDMockito.doReturn(Optional.of(accountEntity)).when(accountRepository).findByUsername(BDDMockito.any());
        accountService.getUserByUserName(BDDMockito.any());
        modelMapper.map(accountEntity, Account.class);

    }

    @Test
    public void testFetchAllUser(){
        BDDMockito.given(accountRepository.findByDisableOrderByUsername(false)).willReturn(Collections.singletonList(accountEntity));
        accountService.fetchAllUser();
    }

    @Test
    public void testAddUser(){
        accountService.addUser(account);
    }

    @Test
    public void testDeleteUser(){
        accountService.deleteUser("uuid");
    }

}
