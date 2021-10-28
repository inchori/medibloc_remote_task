package com.medibloc.distributedledger.repository;


import com.medibloc.distributedledger.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}