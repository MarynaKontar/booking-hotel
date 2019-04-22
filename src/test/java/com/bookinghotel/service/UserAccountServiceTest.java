package com.bookinghotel.service;

import com.bookinghotel.model.entity.User;
import com.bookinghotel.model.entity.UserAccount;
import com.bookinghotel.model.enums.UserRole;
import com.bookinghotel.repository.UserAccountRepository;
import com.bookinghotel.service.impl.UserAccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link UserAccountService}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAccountServiceTest {

    @Autowired
    private UserAccountRepository userAccountRepository;

    private UserAccountService userAccountService;

    @Before
    public void setUp() {
        userAccountService = new UserAccountServiceImpl(userAccountRepository);
    }

    @Test
    @Transactional
    public void save() {
        User user = new User();
        user.setName("name");
        user.setEmail("email@gmail.com");
        user.setRole(UserRole.USER);
        UserAccount userAccount = new UserAccount();
        userAccount.setUser(user);
        assertEquals(5, userAccountRepository.findAll().size());
        userAccountService.add(userAccount);
        assertEquals(6, userAccountRepository.findAll().size());
    }

    @Test
    public void findById() {
        UserAccount userAccount = userAccountService.findById(1L);
        assertEquals(1, (long)userAccount.getId());
    }

    @Test(expected = RuntimeException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
       userAccountService.findById(155L);
    }
}
