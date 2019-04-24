package com.bookinghotel.service.impl;

import com.bookinghotel.exception.BadRequestException;
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
    @Transactional
    public UserAccount add(UserAccount userAccount) {
        if(userAccount.getUser().getRole() == null) {
            userAccount.getUser().setRole(UserRole.USER);
        }
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount findById(Long id) {
        return userAccountRepository.findById(id).orElseThrow(() -> new BadRequestException("userAccount not found " + id));
    }
}
