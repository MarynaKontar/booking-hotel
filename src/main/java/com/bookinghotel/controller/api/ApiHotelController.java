package com.bookinghotel.controller.api;

import com.bookinghotel.converter.dto.HotelDtoConverter;
import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Endpoints for {@link Hotel}
 */
@RestController
@RequestMapping("/hotel")
public class ApiHotelController {

    private final HotelDtoConverter hotelDtoConverter;
    private final HotelService hotelService;

    @Autowired
    public ApiHotelController(HotelDtoConverter hotelDtoConverter, HotelService hotelService) {
        this.hotelDtoConverter = hotelDtoConverter;
        this.hotelService = hotelService;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HttpHeaders> handleException(RuntimeException ex, HttpServletRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("messageError", "Something wrong: " + ex.getMessage()
                + "; path: " + request.getServletPath());
        return ResponseEntity.badRequest().headers(httpHeaders).build();
    }
}
