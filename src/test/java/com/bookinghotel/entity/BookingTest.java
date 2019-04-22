package com.bookinghotel.entity;

import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.entity.UserAccount;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Test for {@link Booking}
 */
public class BookingTest {

    private Booking booking1;
    private Booking booking2;
    private Room room;
    private UserAccount userAccount;
    private LocalDate arrival;
    private LocalDate departure;


    @Before
    public void setUp() {

        room = Mockito.mock(Room.class);
        userAccount = Mockito.mock(UserAccount.class);
        booking1 = new Booking();
        booking1.setId(1L);
        booking1.setTotalPrice(BigDecimal.valueOf(500L));
        arrival = LocalDate.of(2020, 5, 1);
        departure = LocalDate.of(2020, 5, 15);
        booking1.setArrival(arrival);
        booking1.setDeparture(departure);
        booking1.setRoom(room);
        booking1.setUserAccount(userAccount);

        booking2 = new Booking();
        booking2.setId(1L);
        booking2.setTotalPrice(BigDecimal.valueOf(500L));
        booking2.setArrival(LocalDate.of(2020, 5, 1));
        booking2.setDeparture(LocalDate.of(2020, 5, 15));
        booking2.setRoom(room);
        booking2.setUserAccount(userAccount);

    }

    @Test
    public void creationTest() {
        assertEquals(1L, (long) booking1.getId());
        assertEquals(BigDecimal.valueOf(500L), booking1.getTotalPrice());
        assertEquals(LocalDate.of(2020, 5, 1), booking1.getArrival());
        assertEquals(LocalDate.of(2020, 5, 15), booking1.getDeparture());
        assertEquals(room, booking1.getRoom());
        assertEquals(userAccount, booking1.getUserAccount());
    }

    @Test
    public void equalsTest() {
        assertReflectionEquals(booking1, booking2);
        assertTrue("equals by method", booking1.equals(booking2));
        booking2.setId(2L);
        assertFalse(booking1.equals(booking2));

        booking2.setId(1L);
        assertTrue("equals by method", booking1.equals(booking2));
        booking2.setTotalPrice(BigDecimal.valueOf(300L));
        assertFalse(booking1.equals(booking2));

        booking2.setTotalPrice(BigDecimal.valueOf(500L));
        assertTrue("equals by method", booking1.equals(booking2));
        booking2.setDeparture(LocalDate.of(2020, 5, 10));
        assertFalse(booking1.equals(booking2));

        booking2.setDeparture(departure);
        assertTrue("equals by method", booking1.equals(booking2));
        booking2.setArrival(LocalDate.of(2020, 5, 25));
        assertFalse(booking1.equals(booking2));

        booking2.setArrival(arrival);
        assertTrue("equals by method", booking1.equals(booking2));
        booking2.setRoom(Mockito.mock(Room.class));
        assertFalse(booking1.equals(booking2));

        booking2.setRoom(room);
        assertTrue("equals by method", booking1.equals(booking2));
        booking2.setUserAccount(Mockito.mock(UserAccount.class));
        assertFalse(booking1.equals(booking2));
    }
}
