package com.bookinghotel.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookingSearchingDto {
    private List<BookingDto> bookings;
    private UserAccountDto userAccount;
    private HotelDto hotel;
}
