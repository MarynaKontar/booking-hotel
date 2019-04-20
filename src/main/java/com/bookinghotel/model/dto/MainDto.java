package com.bookinghotel.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class MainDto extends AbstractDto{
    private List<HotelDto> hotels;
    private List<RoomDto> rooms;
}
