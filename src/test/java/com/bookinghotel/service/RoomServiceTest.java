package com.bookinghotel.service;

import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.enums.RoomCategory;
import com.bookinghotel.repository.RoomRepository;
import com.bookinghotel.service.impl.RoomServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link RoomService}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceTest {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired

    private RoomService roomService;
    private long size;

    @Before
    public void setUp() {
        roomService = new RoomServiceImpl(roomRepository);
        size =  18;
    }

    @Test
    public void findById() {
        Room room = roomService.findById(1L);
        assertEquals(1, (long)room.getId());
    }

    @Test(expected = RuntimeException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        roomService.findById(155L);
    }

    @Test
    public void findAll() {
        assertEquals(size, roomService.getAll().size());
    }

    @Test
    @Transactional
    public void getAllForDates() {
        LocalDate checkIn = LocalDate.of(2019, 10, 1);
        LocalDate checkOut = LocalDate.of(2019, 11, 30);
        assertEquals(14, roomService.getAllForDates(checkIn, checkOut).size());
    }

    @Test
    @Transactional
    public void getAllByCategory() {
        assertEquals(12, roomService.getAllByCategory(RoomCategory.SUITE).size());
        assertEquals(2, roomService.getAllByCategory(RoomCategory.PRESIDENT).size());
        assertEquals(0, roomService.getAllByCategory(RoomCategory.STANDART).size());
    }
}
