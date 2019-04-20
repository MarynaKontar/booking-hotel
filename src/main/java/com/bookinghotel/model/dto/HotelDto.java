package com.bookinghotel.model.dto;

import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.enums.HotelRating;
import lombok.Data;

import java.util.List;

@Data
public class HotelDto extends AbstractDto {
    private String name;
    private String city;
    private HotelRating hotelRating;
//    private List<RoomDto> rooms;
}
