package com.bookinghotel.entity;

import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.enums.HotelRating;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Test for {@link Hotel}
 */
public class HotelTest {

    private Hotel hotel1;
    private Hotel hotel2;
    private Room room;


    @Before
    public void setUp() {

        room = Mockito.mock(Room.class);
        hotel1 = new Hotel();
        hotel1.setId(1L);
        hotel1.setName("hotel1");
        hotel1.setCity("city1");
        hotel1.setHotelRating(HotelRating.FIVE_STAR);
        hotel1.setRooms(new ArrayList<>(Arrays.asList(room)));

        hotel2 = new Hotel();
        hotel2.setId(1L);
        hotel2.setName("hotel1");
        hotel2.setCity("city1");
        hotel2.setHotelRating(HotelRating.FIVE_STAR);
        hotel2.setRooms(new ArrayList<>(Arrays.asList(room)));

    }

    @Test
    public void creationTest() {
        hotel1.setId(1l);
        assertEquals(1L, (long)hotel1.getId());

        hotel1.setCity("city1");
        assertEquals("city1", hotel1.getCity());

        hotel1.setName("name1");
        assertEquals("name1", hotel1.getName());

        hotel1.setHotelRating(HotelRating.FOUR_STAR);
        assertEquals(HotelRating.FOUR_STAR, hotel1.getHotelRating());
    }

    @Test
    public void roomTest() {
        Room room = Mockito.mock(Room.class);
        assertEquals(1, hotel1.getRooms().size());
        hotel1.addRoom(room);
        assertEquals(2, hotel1.getRooms().size());
        hotel1.removeRoom(room);
        assertEquals(1, hotel1.getRooms().size());
    }

    @Test
    public void equalsTest() throws Exception {
        assertReflectionEquals(hotel1, hotel2);
        assertTrue("equals by method", hotel1.equals(hotel2));
        hotel2.setId(2L);
        assertFalse(hotel1.equals(hotel2));
        hotel2.setId(1L);
        assertTrue("equals by method", hotel1.equals(hotel2));
        hotel2.setName("hotel2");
        assertFalse(hotel1.equals(hotel2));
    }

    @Test
    public void hashCodeTest() throws Exception {
        assertEquals(hotel1.hashCode(), hotel2.hashCode());
        hotel2.setId(2L);
        assertNotEquals(hotel1.hashCode(), hotel2.hashCode());
        hotel2.setId(1L);
        assertEquals(hotel1.hashCode(), hotel2.hashCode());
        hotel2.setName("hotel2");
        assertNotEquals(hotel1.hashCode(), hotel2.hashCode());

        hotel2.setName("hotel1");
        hotel2.setHotelRating(HotelRating.THREE_STAR);
        assertNotEquals(hotel1.hashCode(), hotel2.hashCode());

        hotel2.setHotelRating(HotelRating.FIVE_STAR);
        hotel2.setCity("city2");
        assertNotEquals(hotel1.hashCode(), hotel2.hashCode());

        hotel2.setCity("city1");
        room = Mockito.mock(Room.class);
        hotel2.setRooms(new ArrayList<>(Arrays.asList(room)));
        assertNotEquals(hotel1.hashCode(), hotel2.hashCode());
    }
}
