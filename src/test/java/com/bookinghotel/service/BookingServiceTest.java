package com.bookinghotel.service;

import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.entity.UserAccount;
import com.bookinghotel.repository.BookingRepository;
import com.bookinghotel.service.impl.BookingServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link BookingService}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTest {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private RoomService roomService;

    private BookingService bookingService;

    @Before
    public void setup() {
        bookingService = new BookingServiceImpl(bookingRepository, userAccountService, roomService);
    }

    @Test
    @Transactional
    public void save() {
        Booking booking = new Booking();
        booking.setTotalPrice(BigDecimal.valueOf(500L));
        booking.setArrival(LocalDate.of(2020, 5, 1));
        booking.setDeparture(LocalDate.of(2020, 5, 15));
        Room room = new Room();
        room.setId(1L);
        booking.setRoom(room);
        UserAccount userAccount = new UserAccount();
        userAccount.setId(1L);
        booking.setUserAccount(userAccount);
        assertEquals(10, bookingRepository.findAll().size());
        bookingService.add(booking, userAccount);
        assertEquals(11, bookingRepository.findAll().size());
    }

    @Test(expected = RuntimeException.class)
    @Transactional
    public void saveThrowException() {
        Booking booking = new Booking();
        booking.setTotalPrice(BigDecimal.valueOf(500L));
        booking.setArrival(LocalDate.of(2019, 10, 1));
        booking.setDeparture(LocalDate.of(2019, 11, 30));
        Room room = new Room();
        room.setId(1L);
        booking.setRoom(room);
        UserAccount userAccount = new UserAccount();
        userAccount.setId(1L);
        booking.setUserAccount(userAccount);
        assertEquals(10, bookingRepository.findAll().size());
        bookingService.add(booking, userAccount);
        assertEquals(11, bookingRepository.findAll().size());
    }

    @Test
    public void findById() {
        Booking booking = bookingService.findById(1L);
        assertEquals(1, (long)booking.getId());
    }

    @Test(expected = RuntimeException.class)
    public void findByIdThrowException() {
        bookingService.findById(155L);
    }

    @Test
    public void findAllByUserAccountId() {
        assertEquals(2, bookingService.findAllByUserAccountId(1L).size());
        assertEquals(2, bookingService.findAllByUserAccountId(2L).size());
    }

    @Test
    public void findAllByHotelId() {
        assertEquals(2, bookingService.findAllByUserAccountId(1L).size());
        assertEquals(2, bookingService.findAllByUserAccountId(2L).size());
    }

    @Test
    public void findAllByArrivalGreaterThanEqualAndDepartureLessThanEqual() {
        LocalDate checkIn = LocalDate.of(2019, 10, 1);
        LocalDate checkOut = LocalDate.of(2019, 11, 30);
        assertEquals(2, bookingService
                .findAllByArrivalGreaterThanEqualAndDepartureLessThanEqual(1L, checkIn, checkOut).size());
    }
}
