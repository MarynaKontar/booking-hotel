package com.bookinghotel.model.dto;

import com.bookinghotel.model.enums.HotelRating;
import lombok.Data;

@Data
public class HotelDto extends AbstractDto {
    private String name;
    private String city;
    private HotelRating hotelRating;
}
