package com.bookinghotel.controller.api;

import com.bookinghotel.converter.dto.HotelDtoConverter;
import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints for {@link Hotel}
 */

@RestController
@RequestMapping("/hotel")
public class ApiHotelController {

//    private final HotelDtoConverter hotelDtoConverter;
//    private final HotelService hotelService;
//
//    @Autowired
//    public ApiHotelController(HotelDtoConverter hotelDtoConverter, HotelService hotelService) {
//        this.hotelDtoConverter = hotelDtoConverter;
//        this.hotelService = hotelService;
//    }


}
