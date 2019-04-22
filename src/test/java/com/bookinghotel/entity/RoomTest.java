package com.bookinghotel.entity;

import com.bookinghotel.model.entity.Cleaning;
import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.model.entity.Meals;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.enums.RoomCategory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Test for {@link Room}
 */
public class RoomTest {

    private Room room1;
    private Room room2;
    private Meals breakfast;
    private Cleaning cleaning;
    private Hotel hotel;

    @Before
    public void setUp() {

        breakfast = Mockito.mock(Meals.class);
        cleaning = Mockito.mock(Cleaning.class);
        hotel = Mockito.mock(Hotel.class);

        room1 = new Room();
        room1.setId(1L);
        room1.setNumber(1);
        room1.setPrice(BigDecimal.valueOf(150));
        room1.setCategory(RoomCategory.APARTMENT);
        room1.setBreakfast(breakfast);
        room1.setCleaningWithAdditionalCost(cleaning);
        room1.setHotel(hotel);

        room2 = new Room();
        room2.setId(1L);
        room2.setNumber(1);
        room2.setPrice(BigDecimal.valueOf(150));
        room2.setCategory(RoomCategory.APARTMENT);
        room2.setBreakfast(breakfast);
        room2.setCleaningWithAdditionalCost(cleaning);
        room2.setHotel(hotel);
    }

    @Test
    public void creationTest() {
        assertEquals(1L, (long)room1.getId());
        assertEquals(1, (long)room1.getNumber());
        assertEquals(BigDecimal.valueOf(150), room1.getPrice());
        assertEquals(RoomCategory.APARTMENT, room1.getCategory());
        assertEquals(breakfast, room1.getBreakfast());
        assertEquals(cleaning, room1.getCleaningWithAdditionalCost());
        assertEquals(hotel, room1.getHotel());
    }

    @Test
    public void equalsTest() {
        assertReflectionEquals(room1, room2);
        assertTrue("equals by method", room1.equals(room2));
        room2.setId(2L);
        assertFalse(room1.equals(room2));

        room2.setId(1L);
        assertTrue("equals by method", room1.equals(room2));
        room2.setNumber(2);
        assertFalse(room1.equals(room2));

        room2.setNumber(1);
        room2.setPrice(BigDecimal.valueOf(250));
        assertFalse(room1.equals(room2));

        room2.setPrice(BigDecimal.valueOf(150));
        assertTrue(room1.equals(room2));
        room2.setCategory(RoomCategory.BUSINESS);
        assertFalse(room1.equals(room2));

        room2.setCategory(RoomCategory.APARTMENT);
        assertTrue(room1.equals(room2));
        room2.setBreakfast(Mockito.mock(Meals.class));
        assertFalse(room1.equals(room2));

        room2.setBreakfast(breakfast);
        assertTrue(room1.equals(room2));
        room2.setCleaningWithAdditionalCost(Mockito.mock(Cleaning.class));
        assertFalse(room1.equals(room2));

        room2.setCleaningWithAdditionalCost(cleaning);
        assertTrue(room1.equals(room2));
        room2.setHotel(Mockito.mock(Hotel.class));
        assertFalse(room1.equals(room2));
    }

    @Test
    public void hashCodeTest() {

        assertEquals(room1.hashCode(), room2.hashCode());
        room2.setId(2L);
        assertNotEquals(room1.hashCode(), room2.hashCode());
        room2.setId(1L);
        assertEquals(room1.hashCode(), room2.hashCode());
        room2.setNumber(2);
        assertNotEquals(room1.hashCode(), room2.hashCode());

        room2.setNumber(1);
        room2.setPrice(BigDecimal.valueOf(250));
        assertNotEquals(room1.hashCode(), room2.hashCode());

        room2.setPrice(BigDecimal.valueOf(150));
        room2.setCategory(RoomCategory.BUSINESS);
        assertNotEquals(room1.hashCode(), room2.hashCode());

        room2.setCategory(RoomCategory.APARTMENT);
        room2.setBreakfast(Mockito.mock(Meals.class));
        assertNotEquals(room1.hashCode(), room2.hashCode());

        room2.setBreakfast(breakfast);
        room2.setCleaningWithAdditionalCost(Mockito.mock(Cleaning.class));
        assertNotEquals(room1.hashCode(), room2.hashCode());

        room2.setCleaningWithAdditionalCost(cleaning);
        room2.setHotel(Mockito.mock(Hotel.class));
        assertNotEquals(room1.hashCode(), room2.hashCode());
    }
}
