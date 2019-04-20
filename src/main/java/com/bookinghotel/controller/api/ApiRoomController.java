package com.bookinghotel.controller.api;

import com.bookinghotel.converter.dto.RoomDtoConverter;
import com.bookinghotel.model.dto.RoomSearchingDto;
import com.bookinghotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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

    @PostMapping("/byDates")
    public ResponseEntity<RoomSearchingDto> getRoomsForDates(@RequestBody @NotNull RoomSearchingDto roomSearchingDto) {
        roomSearchingDto.setRooms(roomDtoConverter.transform(roomService.getAllRorDates(roomSearchingDto.getCheckIn(), roomSearchingDto.getCheckOut())));
        return ResponseEntity.ok().body(roomSearchingDto);
    }

    @PostMapping("/byCategory")
    public ResponseEntity<RoomSearchingDto> getRoomsByCategory(@RequestBody @NotNull RoomSearchingDto roomSearchingDto) {
        roomSearchingDto.setRooms(roomDtoConverter.transform(roomService.getAllByCategory(roomSearchingDto.getRoomCategory())));
        return ResponseEntity.ok().body(roomSearchingDto);
    }
}
