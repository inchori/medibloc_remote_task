package com.medibloc.distributedledger.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_account_id")
    private Long id;

    @Column(name = "user_name", unique = true)
    private String name;

    @Column(name = "user_balance")
    private Long amount = 0L;
}
