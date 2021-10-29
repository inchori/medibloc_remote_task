package com.medibloc.distributedledger.dto;

import com.medibloc.distributedledger.entity.UserAccount;
import lombok.*;

public class UserResponse {

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Deposit {
        private Long id;
        private String name;
        private Long amount;

        public static UserResponse.Deposit build(UserAccount userAccount) {
            DepositBuilder depositBuilder = Deposit.builder()
                    .id(userAccount.getId())
                    .name(userAccount.getName())
                    .amount(userAccount.getAmount());

            return depositBuilder.build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class GetBalance {
        private Long id;
        private String name;
        private Long balance;

        public static GetBalance build(UserAccount userAccount) {
            GetBalanceBuilder getBalanceBuilder = GetBalance.builder()
                    .id(userAccount.getId())
                    .name(userAccount.getName())
                    .balance(userAccount.getAmount());
            return getBalanceBuilder.build();
        }
    }
}
