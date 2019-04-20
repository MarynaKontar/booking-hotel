package com.bookinghotel.service;

import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.enums.RoomCategory;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface RoomService {
    Room add(Room room);
    Room getById(Long roomId);
    List<Room> getAll();
    Set<Room> getAllRorDates(LocalDate checkIn, LocalDate checkOut);
    Set<Room> getAllByCategory(RoomCategory roomCategory);

}
