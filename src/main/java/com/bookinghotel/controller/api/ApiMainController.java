package com.bookinghotel.controller.api;

import com.bookinghotel.converter.dto.HotelDtoConverter;
import com.bookinghotel.converter.dto.RoomDtoConverter;
import com.bookinghotel.model.dto.MainDto;
import com.bookinghotel.service.HotelService;
import com.bookinghotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class ApiMainController {
    private final HotelDtoConverter hotelDtoConverter;
    private final HotelService hotelService;
    private final RoomDtoConverter roomDtoConverter;
    private final RoomService roomService;

    @Autowired
    public ApiMainController(HotelDtoConverter hotelDtoConverter, HotelService hotelService,
                             RoomDtoConverter roomDtoConverter, RoomService roomService) {
        this.hotelDtoConverter = hotelDtoConverter;
        this.hotelService = hotelService;
        this.roomDtoConverter = roomDtoConverter;
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<MainDto> getInformationForBooking() {
        MainDto mainDto = new MainDto();
        mainDto.setHotels(hotelDtoConverter.transform(hotelService.getAll()));
        mainDto.setRooms(roomDtoConverter.transform(roomService.getAll()));
        return ResponseEntity.ok().body(mainDto);
    }
}
