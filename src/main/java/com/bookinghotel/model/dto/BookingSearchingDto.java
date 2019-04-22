package com.bookinghotel.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingSearchingDto {
    private List<BookingDto> bookings;
    private HotelDto hotel;
}
