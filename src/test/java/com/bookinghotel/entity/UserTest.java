package com.bookinghotel.entity;

import com.bookinghotel.model.entity.User;
import com.bookinghotel.model.enums.UserRole;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Test for {@link User}
 */
public class UserTest {
    private User user1;
    private User user2;

    @Before
    public void setUp() {

        user1 = new User();
        user1.setId(1L);
        user1.setName("user1");
        user1.setEmail("email1@gmail.com");
        user1.setRole(UserRole.USER);

        user2 = new User();
        user2.setId(1L);
        user2.setName("user1");
        user2.setEmail("email1@gmail.com");
        user2.setRole(UserRole.USER);
    }

    @Test
    public void creationTest() {
        user1.setId(1l);
        assertEquals(1L, (long)user1.getId());

        user1.setName("name1");
        assertEquals("name1", user1.getName());

        user1.setEmail("email1@gmail.com");
        assertEquals("email1@gmail.com", user1.getEmail());

        user1.setRole(UserRole.USER);
        assertEquals(UserRole.USER, user1.getRole());
    }

    @Test
    public void equalsTest() {
        assertReflectionEquals(user1, user2);
        assertTrue("equals by method", user1.equals(user2));
        user2.setId(2L);
        assertFalse(user1.equals(user2));
        user2.setId(1L);
        assertTrue("equals by method", user1.equals(user2));
        user2.setName("user2");
        assertFalse(user1.equals(user2));
    }

    @Test
    public void hashCodeTest() {
        assertEquals(user1.hashCode(), user2.hashCode());
        user2.setId(2L);
        assertNotEquals(user1.hashCode(), user2.hashCode());
        user2.setId(1L);
        assertEquals(user1.hashCode(), user2.hashCode());
        user2.setName("user2");
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }
}