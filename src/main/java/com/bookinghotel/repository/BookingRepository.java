package com.bookinghotel.repository;

import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByUserAccountId(Long userAccountId);

    @Query("SELECT b FROM Booking b WHERE b.room.hotel.id = (?1) ORDER BY b.arrival")
    List<Booking> findAllByHotelIdOrderByArrival(Long hotelId);

    List<Booking> findAllByRoomAndDepartureGreaterThanEqualAndArrivalLessThanEqual(Room room, LocalDate checkIn, LocalDate checkOut);
}
