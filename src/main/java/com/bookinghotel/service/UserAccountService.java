package com.bookinghotel.service;

import com.bookinghotel.model.entity.UserAccount;

public interface UserAccountService {
    UserAccount add(UserAccount userAccount);
    UserAccount findById(Long userAccountId);
}
