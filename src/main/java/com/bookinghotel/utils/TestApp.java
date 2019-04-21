package com.bookinghotel.utils;

import com.bookinghotel.model.entity.*;
import com.bookinghotel.model.enums.HotelRating;
import com.bookinghotel.model.enums.MealsType;
import com.bookinghotel.model.enums.RoomCategory;
import com.bookinghotel.model.enums.UserRole;
import com.bookinghotel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class TestApp {
    private static Integer roomNumber = 0;
    private static Integer hotelNumber = 0;
    private static Integer userNumber = 0;

    private final UserService userService;
    private final UserAccountService userAccountService;
    private final RoomService roomService;
    private final HotelService hotelService;
    private final BookingService bookingService;

    @Autowired
    public TestApp(UserService userService, UserAccountService userAccountService,
                   RoomService roomService, HotelService hotelService,
                   BookingService bookingService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
        this.roomService = roomService;
        this.hotelService = hotelService;
        this.bookingService = bookingService;
    }

    @PostConstruct
    public void testBooking() {

        //create three hotels
        Hotel hotel1 = hotelService.add(getHotel());
        Hotel hotel2 = hotelService.add(getHotel());
        Hotel hotel3 = hotelService.add(getHotel());

        //create nine rooms and set them to hotels
        Room room1 = hotelService.addRoom(getRoom(), hotel1);
        Room room2 = hotelService.addRoom(getRoom(), hotel1);
        Room room3 = hotelService.addRoom(getRoom(), hotel2);
        Room room4 = hotelService.addRoom(getRoom(), hotel2);
        Room room5 = hotelService.addRoom(getRoom(), hotel3);
        Room room6 = hotelService.addRoom(getRoom(), hotel3);
        Room room7 = hotelService.addRoom(getRoom(), hotel1);
        Room room8 = hotelService.addRoom(getRoom(), hotel2);
        Room room9 = hotelService.addRoom(getRoom(), hotel3);

        //create first user
        User user1 = getUser();
        UserAccount userAccount1 = getUserAccount(user1);
        userAccount1 = userAccountService.add(userAccount1);

        //create second user
        User user2 = getUser();
        UserAccount userAccount2 = getUserAccount(user2);
        userAccount2 = userAccountService.add(userAccount2);


        //create five bookings
        Booking booking1 = new Booking();
        booking1.setRoom(room1);
        booking1.setUserAccount(userAccount1);
        booking1.setArrival(LocalDate.of(2019, 10, 25));
        booking1.setDeparture(LocalDate.of(2019, 10, 30));
        booking1.setTotalPrice(bookingService.getTotalPrice(booking1));
        bookingService.add(booking1, userAccount1);

        Booking booking2 = new Booking();
        booking2.setRoom(room7);
        booking2.setUserAccount(userAccount2);
        booking2.setArrival(LocalDate.of(2019, 9, 25));
        booking2.setDeparture(LocalDate.of(2019, 9, 30));
        booking2.setTotalPrice(bookingService.getTotalPrice(booking2));
        bookingService.add(booking2, userAccount2);

        Booking booking3 = new Booking();
        booking3.setRoom(room1);
        booking3.setUserAccount(userAccount1);
        booking3.setArrival(LocalDate.of(2019, 11, 15));
        booking3.setDeparture(LocalDate.of(2019, 11, 30));
        booking3.setTotalPrice(bookingService.getTotalPrice(booking3));
        bookingService.add(booking3, userAccount1);

        Booking booking4 = new Booking();
        booking4.setRoom(room3);
        booking4.setUserAccount(userAccount1);
        booking4.setArrival(LocalDate.of(2019, 11, 10));
        booking4.setDeparture(LocalDate.of(2019, 11, 14));
        booking4.setTotalPrice(bookingService.getTotalPrice(booking4));
        bookingService.add(booking4, userAccount1);

        Booking booking5 = new Booking();
        booking5.setRoom(room1);
        booking5.setUserAccount(userAccount2);
        booking5.setArrival(LocalDate.of(2019, 9, 11));
        booking5.setDeparture(LocalDate.of(2019, 9, 30));
        booking5.setTotalPrice(bookingService.getTotalPrice(booking5));
        bookingService.add(booking5, userAccount2);
    }

    private Hotel getHotel() {
        hotelNumber ++;
        Hotel hotel = new Hotel();
        hotel.setName("Marriot" + hotelNumber);
        hotel.setCity("London");
        hotel.setHotelRating(HotelRating.FIVE_PLUS_STAR);
        return hotel;
    }
    private Room getRoom() {
        roomNumber ++;
        Room room = new Room();
        room.setNumber(roomNumber);
        room.setCategory(RoomCategory.SUITE);
        Meals meals =  new Meals();
        meals.setMealsType(MealsType.BREAKFAST);
        meals.setPrice(BigDecimal.valueOf(150 + roomNumber));
        room.setBreakfast(meals);
        Cleaning cleaning = new Cleaning();
        cleaning.setPrice(BigDecimal.valueOf(50));
        room.setCleaningWithAdditionalCost(cleaning);
        room.setPrice(BigDecimal.valueOf(200 + roomNumber));
        return room;
    }

    private User getUser() {
        userNumber ++;
        User user = new User();
        user.setName("user" + userNumber);
        user.setEmail("email" + userNumber.toString() + "@gmail.com");
        user.setRole(UserRole.USER);
        return user;
    }
    private UserAccount getUserAccount(User user) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUser(user);
        return userAccount;
    }

}
