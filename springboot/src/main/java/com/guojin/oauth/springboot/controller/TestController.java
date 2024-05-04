package com.guojin.oauth.springboot.controller;

import com.guojin.oauth.springboot.model.Account;
import com.guojin.oauth.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/")
    public String test(){
        return "Welcome";
    }

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String register(@RequestBody Account user) {
        accountService.register(user);
        return "success";
    }
}
