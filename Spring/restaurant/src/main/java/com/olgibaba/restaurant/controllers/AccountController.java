package com.olgibaba.restaurant.controllers;

import com.olgibaba.restaurant.buisness.services.AccountService;
import com.olgibaba.restaurant.payload.request.AdminLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/restaurant")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/adminSignIn")
    public ResponseEntity<?> signIn (@Valid @RequestBody AdminLoginRequest adminLoginRequest){

        return this.accountService.signIn(adminLoginRequest);

    }

}
