package com.bookinghotel.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingDto extends AbstractDto {
    private UserAccountDto userAccount;
    private RoomDto room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private BigDecimal totalPrice;
}
