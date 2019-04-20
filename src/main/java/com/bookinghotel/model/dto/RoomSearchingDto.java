package com.bookinghotel.model.dto;

import com.bookinghotel.model.enums.RoomCategory;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RoomSearchingDto {
    private List<RoomDto> rooms;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private RoomCategory roomCategory;
}
