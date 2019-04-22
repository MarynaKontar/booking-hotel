package com.bookinghotel.service;

import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.model.entity.Room;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface HotelService {
    Hotel add(Hotel hotel);
    Room addRoom(Room room, @NotNull Hotel hotel);

    Hotel findById(Long id);
    List<Hotel> getAll();
}
