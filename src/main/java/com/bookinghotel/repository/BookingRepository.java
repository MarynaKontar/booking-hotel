package com.bookinghotel.repository;

import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByArrivalAndDeparture(LocalDate checkIn, LocalDate checkOut);
    List<Booking> findAllByUserAccountId(Long userAccountId);

    @Query("SELECT b FROM Booking b WHERE b.room.hotel.id = (?1)")
    List<Booking> findAllByHotelId(Long hotelId);
}