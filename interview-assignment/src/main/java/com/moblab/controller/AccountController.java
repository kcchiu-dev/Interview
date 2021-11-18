package com.moblab.controller;

import com.moblab.model.Status;
import com.moblab.service.AccountService;
import com.moblab.shared.Account;
import com.moblab.shared.request.ServerRequest;
import com.moblab.shared.response.ServerResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiResponses(value = {@ApiResponse(code=200,message = "search success")})
    @ApiOperation("search account by username")
    @GetMapping("/{username}")
    @ResponseBody
    public ServerResponse getUserByUsername(@PathVariable String username){
        Account account = accountService.getUserByUserName(username);
        ServerResponse response = new ServerResponse();
        response.setStatus(Status.SUCCESS);
        response.setAccount(account);
        return response;
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "search success")})
    @ApiOperation("search all account")
    @GetMapping
    @ResponseBody
    public List<Account> fetchAllUser(){
        return accountService.fetchAllUser();
    }


    @ApiResponses(value = {@ApiResponse(code=200,message = "insert success")})
    @ApiOperation("add account")
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Object addAccount(@RequestBody ServerRequest request){
        return accountService.addUser(request.getAccount());
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "delete success")})
    @ApiOperation("disable user")
    @DeleteMapping("/{userId}")
    @ResponseBody
    public Object deleteAccount(@PathVariable("userId") String userId){
        return accountService.deleteUser(userId);
    }



}
