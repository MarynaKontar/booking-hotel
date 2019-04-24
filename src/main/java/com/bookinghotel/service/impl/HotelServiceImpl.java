package com.bookinghotel.service.impl;

import com.bookinghotel.exception.BadRequestException;
import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.repository.HotelRepository;
import com.bookinghotel.repository.RoomRepository;
import com.bookinghotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class HotelServiceImpl implements HotelService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel add(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    @Transactional
    public Room addRoom(Room room, @NotNull Hotel hotel) {
        Hotel savedHotel = hotelRepository.findById(hotel.getId())
        .orElseGet(() -> add(hotel));

        savedHotel.addRoom(room);
        return roomRepository.save(room);
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new BadRequestException("hotel not found " + id));
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }
}
