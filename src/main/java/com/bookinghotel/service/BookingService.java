package com.bookinghotel.service;

import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.UserAccount;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    Booking add(Booking booking, UserAccount userAccount);

    Booking findById(Long id);
    BigDecimal getTotalPrice(Booking booking);
    List<Booking> findAllByUserAccountId(Long userAccountId);
    List<Booking> findAllByHotelId(Long hotelId);
    List<Booking> findAllByArrivalGreaterThanEqualAndDepartureLessThanEqual(Long roomId, LocalDate checkIn, LocalDate checkOut);
}
