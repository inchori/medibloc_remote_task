package com.medibloc.distributedledger.service;

import com.medibloc.distributedledger.dto.UserRequest;
import com.medibloc.distributedledger.dto.UserResponse;
import com.medibloc.distributedledger.entity.UserAccount;
import com.medibloc.distributedledger.exception.UserNotFoundException;
import com.medibloc.distributedledger.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Service
@Transactional
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserResponse.Deposit depositDollars(UserRequest.Deposit request) {
        if (userAccountRepository.existsByName(request.getName())) {
            throw new IllegalStateException("The use is already exist.");
        }
        UserAccount depositAccount = userAccountRepository.save(UserAccount.deposit(request));
        return UserResponse.Deposit.build(depositAccount);
    }

    @Transactional(readOnly = true)
    public UserResponse.GetBalance getBalance(Long id) {
        UserAccount userAccount = userAccountRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return UserResponse.GetBalance.build(userAccount);
    }
}
