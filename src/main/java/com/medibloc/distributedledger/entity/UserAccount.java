package com.medibloc.distributedledger.entity;

import com.medibloc.distributedledger.dto.UserRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user_account")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_account_id")
    private Long id;

    @Column(name = "user_name", unique = true)
    private String name;

    @Column(name = "user_balance")
    private long amount;

    public static UserAccount deposit(UserRequest.Deposit request) {
        return UserAccount.builder()
                .name(request.getName())
                .amount(request.getAmount())
                .build();
    }
}
