package com.medibloc.distributedledger.controller;

import com.medibloc.distributedledger.dto.UserRequest;
import com.medibloc.distributedledger.dto.UserResponse;
import com.medibloc.distributedledger.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/account")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping(value = "/deposit")
    public ResponseEntity<UserResponse.Deposit> depositDollars(@RequestBody UserRequest.Deposit request) {
        return ResponseEntity.ok().body(userAccountService.depositDollars(request));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse.GetBalance> getBalance(@PathVariable Long id) {
        return ResponseEntity.ok().body(userAccountService.getBalance(id));
    }
}
