package com.bookinghotel.controller.api;

import com.bookinghotel.converter.dto.BookingDtoConverter;
import com.bookinghotel.converter.dto.HotelDtoConverter;
import com.bookinghotel.converter.dto.UserAccountDtoConverter;
import com.bookinghotel.model.dto.BookingDto;
import com.bookinghotel.model.dto.BookingSearchingDto;
import com.bookinghotel.model.dto.HotelDto;
import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.service.BookingService;
import com.bookinghotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Endpoint for {@link Booking}
 */
@RestController
@RequestMapping("/booking")
public class ApiBookingController {
    private final BookingService bookingService;
    private final HotelService hotelService;
    private final BookingDtoConverter bookingDtoConverter;
    private final UserAccountDtoConverter userAccountDtoConverter;
    private final HotelDtoConverter hotelDtoConverter;

    @Autowired
    public ApiBookingController(BookingService bookingService,
                                HotelService hotelService, BookingDtoConverter bookingDtoConverter,
                                UserAccountDtoConverter userAccountDtoConverter, HotelDtoConverter hotelDtoConverter) {
        this.bookingService = bookingService;
        this.hotelService = hotelService;
        this.bookingDtoConverter = bookingDtoConverter;
        this.userAccountDtoConverter = userAccountDtoConverter;
        this.hotelDtoConverter = hotelDtoConverter;
    }

    /**
     * Endpoint for saving booking
     * @param bookingDto booking dto for saving
     * @return {@link ResponseEntity<BookingDto>} object holding the saving {@link BookingDto}
     */
    @PostMapping
    public ResponseEntity<BookingDto> create(@RequestBody @NotNull @Valid BookingDto bookingDto) {
        Booking booking = bookingService.add(bookingDtoConverter.transform(bookingDto),
                userAccountDtoConverter.transform(bookingDto.getUserAccount()));
        return new ResponseEntity<>(bookingDtoConverter.transform(booking), HttpStatus.CREATED);
    }

    /**
     * Endpoint to get {@link ResponseEntity<BookingSearchingDto>} holding the {@link BookingSearchingDto}
     * with list of all {@link BookingDto} for userAccount with userAccountId
     * @param userAccountId id of the userAccount
     * @return {@link ResponseEntity<BookingSearchingDto>} holding the {@link BookingSearchingDto}
     * with list of all {@link BookingDto} for userAccount
     */
    @GetMapping("/{userAccountId}")
    public ResponseEntity<BookingSearchingDto> getBookingsForUser(@PathVariable Long userAccountId) {
        List<Booking> bookings = bookingService.findAllByUserAccountId(userAccountId);
        BookingSearchingDto bookingSearchingDto = new BookingSearchingDto();
        List<BookingDto> bookingDtos = bookingDtoConverter.transform(bookings);
        bookingSearchingDto.setBookings(bookingDtos);
        return ResponseEntity.ok(bookingSearchingDto);
    }

    /**
     * Endpoint to get {@link ResponseEntity<BookingSearchingDto>} holding the {@link BookingSearchingDto}
     * with list of {@link BookingDto} for hotel with hotelId
     * @param hotelId id of the hotel
     * @return {@link ResponseEntity<BookingSearchingDto>} holding the {@link BookingSearchingDto}
     * with list of {@link BookingDto} for hotel with hotelId
     */
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<BookingSearchingDto> getBookingsForHotel(@PathVariable Long hotelId) {
        List<Booking> bookings = bookingService.findAllByHotelId(hotelId);
        BookingSearchingDto bookingSearchingDto = new BookingSearchingDto();
        List<BookingDto> bookingDtos = bookingDtoConverter.transform(bookings);
        bookingSearchingDto.setBookings(bookingDtos);
        HotelDto hotelDto = hotelDtoConverter.transform(hotelService.findById(hotelId));
        bookingSearchingDto.setHotel(hotelDto);
        return ResponseEntity.ok(bookingSearchingDto);
    }

    /**
     * Endpoint to get {@link ResponseEntity<BigDecimal>} object holding the total booking price
     * @param id booking id
     * @return {@link ResponseEntity<BigDecimal>} object holding the total booking price
     */
    @GetMapping("/totalPrice/{id}")
    public ResponseEntity<BigDecimal> getTotalPriceForBooking(@PathVariable Long id) {
        Booking booking = bookingService.findById(id);
        return ResponseEntity.ok(bookingService.getTotalPrice(booking));
    }

//    @GetMapping("/forRoomAndDates")
//    public ResponseEntity<BookingSearchingDto> getBookingsForDates(@RequestParam(value = "roomId") @NotEmpty Long roomId,
//                                                                   @RequestParam(value = "checkIn") @NotEmpty
//                                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                                                                   LocalDate checkIn,
//                                                                   @RequestParam(value = "checkOut") @NotEmpty
//                                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                                                                   LocalDate checkOut) {
//        List<Booking> bookings = bookingService.findAllByArrivalGreaterThanEqualAndDepartureLessThanEqual(roomId, checkIn, checkOut);
//        BookingSearchingDto bookingSearchingDto = new BookingSearchingDto();
//        List<BookingDto> bookingDtos = bookingDtoConverter.transform(bookings);
//        bookingSearchingDto.setBookings(bookingDtos);
//        return ResponseEntity.ok(bookingSearchingDto);
//    }
}
