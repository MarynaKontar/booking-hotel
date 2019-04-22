package com.bookinghotel.service;

import com.bookinghotel.model.entity.Cleaning;
import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.model.entity.Meals;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.enums.HotelRating;
import com.bookinghotel.model.enums.RoomCategory;
import com.bookinghotel.repository.HotelRepository;
import com.bookinghotel.repository.RoomRepository;
import com.bookinghotel.service.impl.HotelServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link HotelService}
 */
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class HotelServiceTest {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;

    private HotelService hotelService;

    @Before
    public void setUp() {
        hotelService = new HotelServiceImpl(roomRepository, hotelRepository);
    }

    @Test
    public void save() {
        Hotel hotel = new Hotel();
        hotel.setName("Marriot");
        hotel.setCity("London");
        hotel.setHotelRating(HotelRating.FIVE_PLUS_STAR);
        assertEquals(6, hotelService.getAll().size());
        hotelService.add(hotel);
        assertEquals(7, hotelService.getAll().size());
    }

    @Test
    public void findById() {
        Hotel hotel = hotelService.findById(1L);
        assertEquals(1, (long)hotel.getId());
    }

    @Test(expected = RuntimeException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        hotelService.findById(155L);
    }

    @Test
    public void findAll() {
        assertEquals(6, hotelService.getAll().size());
    }

    @Test
    @Transactional
    public void addRoom() {
        assertEquals(18, roomRepository.findAll().size());
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotelService.addRoom(getRoom(), hotel);
        assertEquals(19, roomRepository.findAll().size());
    }

    private Room getRoom() {
        Room room = new Room();
        room.setCleaningWithAdditionalCost(new Cleaning());
        room.setBreakfast(new Meals());
        room.setCategory(RoomCategory.STANDART);
        room.setPrice(BigDecimal.valueOf(500));
        return room;
    }
}
