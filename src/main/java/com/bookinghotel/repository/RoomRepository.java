package com.bookinghotel.repository;

import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.enums.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE r.id NOT IN (SELECT b.room.id FROM Booking b WHERE b.departure >= (?1) and b.arrival <= (?2))")
    Set<Room> findAllByDates(LocalDate checkIn, LocalDate checkOut);

    Set<Room> findRoomByCategory(RoomCategory roomCategory);

}
