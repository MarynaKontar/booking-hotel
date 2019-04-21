package com.bookinghotel.service.impl;

import com.bookinghotel.model.entity.User;
import com.bookinghotel.repository.UserRepository;
import com.bookinghotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User add(User user) {
        return userRepository.save(user);
    }
}
