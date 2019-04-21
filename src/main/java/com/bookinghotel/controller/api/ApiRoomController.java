package com.bookinghotel.controller.api;

import com.bookinghotel.converter.dto.RoomDtoConverter;
import com.bookinghotel.model.dto.RoomSearchingDto;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.enums.RoomCategory;
import com.bookinghotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

/**
 * Endpoints for {@link Room}
 */
@RestController
@RequestMapping("/room")
public class ApiRoomController {
    private final RoomService roomService;
    private final RoomDtoConverter roomDtoConverter;

    @Autowired
    public ApiRoomController(RoomService roomService, RoomDtoConverter roomDtoConverter) {
        this.roomService = roomService;
        this.roomDtoConverter = roomDtoConverter;
    }

    /**
     * Endpoint for get {@link RoomSearchingDto} with list of {@link Room} that are available from checkIn to checkOut
     * @param checkIn the date from which the room should be free
     * @param checkOut the date until which the room should be free
     * @return {@link RoomSearchingDto} with list of {@link Room} that are available from checkIn to checkOut
     */
    @GetMapping("/forDates")
    public ResponseEntity<RoomSearchingDto> getRoomsForDates(@RequestParam(value = "checkIn") @NotEmpty
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                             LocalDate checkIn,
                                                             @RequestParam(value = "checkOut") @NotEmpty
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                             LocalDate checkOut) {
        RoomSearchingDto roomSearchingDto = new RoomSearchingDto();
        roomSearchingDto.setRooms(roomDtoConverter.transform(roomService.getAllForDates(checkIn, checkOut)));
        roomSearchingDto.setCheckIn(checkIn);
        roomSearchingDto.setCheckOut(checkOut);
        return ResponseEntity.ok().body(roomSearchingDto);
    }

    /**
     * Endpoint for get {@link RoomSearchingDto} with list of {@link Room} with {@link RoomCategory} equal roomCategory
     * @param roomCategory the {@link RoomCategory} of {@link Room}
     * @return {@link RoomSearchingDto} with list of {@link Room} with {@link RoomCategory} equal roomCategory
     */
    @GetMapping
    public ResponseEntity<RoomSearchingDto> getRoomsByCategory(@RequestParam(value = "roomCategory") @NotEmpty String roomCategory) {
        RoomSearchingDto roomSearchingDto = new RoomSearchingDto();
        roomSearchingDto.setRooms(roomDtoConverter.transform(roomService.getAllByCategory(RoomCategory.valueOf(roomCategory.toUpperCase()))));
        roomSearchingDto.setRoomCategory(RoomCategory.valueOf(roomCategory.toUpperCase()));
        return ResponseEntity.ok().body(roomSearchingDto);
    }
}
