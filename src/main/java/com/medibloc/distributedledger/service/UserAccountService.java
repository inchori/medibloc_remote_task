package com.medibloc.distributedledger.service;

import com.medibloc.distributedledger.dto.UserRequest;
import com.medibloc.distributedledger.dto.UserResponse;
import com.medibloc.distributedledger.entity.UserAccount;
import com.medibloc.distributedledger.exception.UserNotFoundException;
import com.medibloc.distributedledger.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Transactional(readOnly = false)
    public void depositDollars(UserRequest.Deposit request) {

    }

    @Transactional(readOnly = true)
    public UserResponse.GetBalance getBalance(Long id) {
        UserAccount userAccount = userAccountRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return UserResponse.GetBalance.build(userAccount);
    }
}
