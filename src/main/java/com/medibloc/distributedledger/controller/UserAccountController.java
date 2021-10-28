package com.medibloc.distributedledger.controller;

import com.medibloc.distributedledger.dto.UserRequest;
import com.medibloc.distributedledger.dto.UserResponse;
import com.medibloc.distributedledger.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping("/deposit")
    public UserResponse.Deposit depositDollars(@RequestBody UserRequest.Deposit request) {

    }

    @GetMapping("/{id}")
    public UserResponse.GetBalance getBalance(@PathVariable Long id) {
        return userAccountService.getBalance(id);
    }
}
