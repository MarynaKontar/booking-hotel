package com.bookinghotel.repository;

import com.bookinghotel.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount getById(Long id);
}
