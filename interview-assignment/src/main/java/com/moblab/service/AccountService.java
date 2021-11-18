package com.moblab.service;


import com.moblab.shared.Account;

import java.util.List;

public interface AccountService {

    Account getUserByUserName(String username);

    List<Account> fetchAllUser();

    int addUser(Account account);

    Object deleteUser(String userId);


}
