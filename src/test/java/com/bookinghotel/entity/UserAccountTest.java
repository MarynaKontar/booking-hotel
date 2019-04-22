package com.bookinghotel.entity;

import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.User;
import com.bookinghotel.model.entity.UserAccount;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Test for {@link UserAccount}
 */
public class UserAccountTest {
    private UserAccount userAccount1;
    private UserAccount userAccount2;

    private User user1;
    private User user2;
    private List<Booking> bookings1;
    private List<Booking> bookings2;
    private Booking booking;


    @Before
    public void setUp() {
        user1 = Mockito.mock(User.class);
        user2 = Mockito.mock(User.class);
        booking = Mockito.mock(Booking.class);
        bookings1 = new ArrayList<>(Arrays.asList(booking));
        userAccount1 = new UserAccount();
        userAccount1.setId(1L);
        userAccount1.setUser(user1);
        userAccount1.setBookings(bookings1);

        userAccount2 = new UserAccount();
        userAccount2.setId(1L);
        userAccount2.setUser(user1);
        userAccount2.setBookings(bookings1);
    }

    @Test
    public void creationTest() {
        assertEquals(1L, (long) userAccount1.getId());
        assertEquals(user1, userAccount1.getUser());
        assertEquals(bookings1, userAccount1.getBookings());
    }

    @Test
    public void equalsTest() {
        assertReflectionEquals(userAccount1, userAccount2);
        assertTrue("equals by method", userAccount1.equals(userAccount2));
        userAccount2.setId(2L);
        assertFalse(userAccount1.equals(userAccount2));
        userAccount2.setId(1L);
        assertTrue("equals by method", userAccount1.equals(userAccount2));
        user2.setName("name");
        userAccount2.setUser(user2);
        assertFalse(userAccount1.equals(userAccount2));

        booking = Mockito.mock(Booking.class);
        bookings2 = new ArrayList<>(Arrays.asList(booking));
        assertFalse(userAccount1.equals(userAccount2));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(userAccount1.hashCode(), userAccount2.hashCode());
        userAccount2.setId(2L);
        assertNotEquals(userAccount1.hashCode(), userAccount2.hashCode());

        userAccount2.setId(1L);
        assertEquals(userAccount1.hashCode(), userAccount2.hashCode());
        userAccount2.setUser(user2);
        assertNotEquals(userAccount1.hashCode(), userAccount2.hashCode());

        booking = Mockito.mock(Booking.class);
        bookings2 = new ArrayList<>(Arrays.asList(booking));
        assertNotEquals(userAccount1.hashCode(), userAccount2.hashCode());
    }
}
