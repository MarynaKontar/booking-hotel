package com.bookinghotel.service;

import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.entity.UserAccount;

import java.math.BigDecimal;
import java.util.List;

public interface BookingService {
    Booking add(Booking booking, UserAccount userAccount);

    BigDecimal getTotalPrice(Room room);
    List<Booking> findAllByUserAccountId(Long userAccountId);
    List<Booking> findAllByHotelId(Long hotelId);
}
