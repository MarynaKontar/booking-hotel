package com.bookinghotel.controller.api;

import com.bookinghotel.converter.dto.BookingDtoConverter;
import com.bookinghotel.converter.dto.UserAccountDtoConverter;
import com.bookinghotel.model.dto.BookingDto;
import com.bookinghotel.model.dto.BookingSearchingDto;
import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class ApiBookingController {
    private final BookingService bookingService;
    private final BookingDtoConverter bookingDtoConverter;
    private final UserAccountDtoConverter userAccountDtoConverter;
@Autowired

    public ApiBookingController(BookingService bookingService, BookingDtoConverter bookingDtoConverter, UserAccountDtoConverter userAccountDtoConverter) {
        this.bookingService = bookingService;
        this.bookingDtoConverter = bookingDtoConverter;
    this.userAccountDtoConverter = userAccountDtoConverter;
}

    @PostMapping
    public ResponseEntity<BookingDto> create(@RequestBody @NotNull @Valid BookingDto bookingDto) {
        Booking booking = bookingService.add(bookingDtoConverter.transform(bookingDto), userAccountDtoConverter.transform(bookingDto.getUserAccount()));
        return new ResponseEntity<>(bookingDtoConverter.transform(booking), HttpStatus.CREATED);
    }

    @GetMapping("/{userAccountId}")
    public ResponseEntity<BookingSearchingDto> getBookingForUser(@PathVariable Long userAccountId) {
        List<Booking> bookings = bookingService.findAllByUserAccountId(userAccountId);
        BookingSearchingDto bookingSearchingDto = new BookingSearchingDto();
        List<BookingDto> bookingDtos = bookingDtoConverter.transform(bookings);
        bookingSearchingDto.setBookings(bookingDtos);
        return ResponseEntity.ok(bookingSearchingDto);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<BookingSearchingDto> getBookingForHotel(@PathVariable Long hotelId) {
        List<Booking> bookings = bookingService.findAllByHotelId(hotelId);
        BookingSearchingDto bookingSearchingDto = new BookingSearchingDto();
        List<BookingDto> bookingDtos = bookingDtoConverter.transform(bookings);
        bookingSearchingDto.setBookings(bookingDtos);
        return ResponseEntity.ok(bookingSearchingDto);
    }
}
