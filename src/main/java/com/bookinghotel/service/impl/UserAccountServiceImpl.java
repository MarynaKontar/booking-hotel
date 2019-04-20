package com.bookinghotel.service.impl;

import com.bookinghotel.model.entity.UserAccount;
import com.bookinghotel.model.enums.UserRole;
import com.bookinghotel.repository.UserAccountRepository;
import com.bookinghotel.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public UserAccount add(UserAccount userAccount) {
        userAccount.getUser().setRole(UserRole.USER);
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount findById(Long userAccountId) {
        return userAccountRepository.findById(userAccountId).orElseThrow(() -> new RuntimeException("userAccount not found"));
    }
}
