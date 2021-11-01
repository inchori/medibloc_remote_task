package com.medibloc.distributedledger.service;

import com.medibloc.distributedledger.dto.UserRequest;
import com.medibloc.distributedledger.dto.UserResponse;
import com.medibloc.distributedledger.entity.UserAccount;
import com.medibloc.distributedledger.repository.UserAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {

    @Mock
    private UserAccountRepository userAccountRepository;

    @InjectMocks
    private UserAccountService userAccountService;

    @Test
    @DisplayName("Deposit US Dollars")
    public void deposit() {
        //given
        UserRequest.Deposit request = UserRequest.Deposit.builder()
                .name("Song InChul")
                .amount(10000)
                .build();
        UserAccount userAccount = UserAccount.deposit(request);

        given(userAccountRepository.save(any())).willReturn(userAccount);

        //when
        UserResponse.Deposit createdAccount = userAccountService.depositDollars(request);

        //then
        assertEquals(userAccount.getId(), createdAccount.getId());
        assertEquals(userAccount.getName(), createdAccount.getName());
        assertEquals(userAccount.getAmount(), createdAccount.getAmount());

    }

    @Test
    @DisplayName("Get User Balance")
    public void getBalance() {
        //given
        UserAccount userAccount = UserAccount.builder()
                .id(1L)
                .name("Song InChul")
                .amount(10000)
                .build();
        given(userAccountRepository.findById(userAccount.getId())).willReturn(Optional.of(userAccount));

        //when
        UserResponse.GetBalance findBalance = userAccountService.getBalance(1L);

        //then
        assertEquals(userAccount.getAmount(), findBalance.getBalance());
    }
}