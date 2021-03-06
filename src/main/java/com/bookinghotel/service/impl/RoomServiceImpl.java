package com.bookinghotel.service.impl;

import com.bookinghotel.exception.BadRequestException;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.enums.RoomCategory;
import com.bookinghotel.repository.RoomRepository;
import com.bookinghotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room findById(Long id) {
      return roomRepository.findById(id).orElseThrow(() -> new BadRequestException("room not found " + id));
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Set<Room> getAllForDates(LocalDate checkIn, LocalDate checkOut) {
        return roomRepository.findAllByDates(checkIn, checkOut);
    }

    @Override
    public Set<Room> getAllByCategory(RoomCategory roomCategory) {
        return roomRepository.findRoomByCategory(roomCategory);
    }
}
