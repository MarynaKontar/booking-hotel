package com.bookinghotel.model.dto;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class UserAccountDto extends AbstractDto {
    @Valid
    private UserDto user;
    private List<BookingDto> bookings;
}
