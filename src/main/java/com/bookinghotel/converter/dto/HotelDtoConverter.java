package com.bookinghotel.converter.dto;

import com.bookinghotel.model.dto.HotelDto;
import com.bookinghotel.model.dto.RoomDto;
import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.model.entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelDtoConverter extends AbstractDtoConverter<Hotel, HotelDto> {
    @Override
    protected HotelDto createNewDto() {
        return new HotelDto();
    }

    @Override
    protected Hotel createNewEntity() {
        return new Hotel();
    }

    @Override
    protected void convertFromEntity(Hotel entity, HotelDto dto) {
        RoomDtoConverter roomDtoConverter = new RoomDtoConverter();
//        List<RoomDto> roomDtos = roomDtoConverter.transform(entity.getRooms());
//        dto.setRooms(roomDtos);
        dto.setCity(entity.getCity());
        dto.setName(entity.getName());
        dto.setHotelRating(entity.getHotelRating());
    }

    @Override
    protected void convertFromDto(HotelDto dto, Hotel entity) {
        RoomDtoConverter roomDtoConverter = new RoomDtoConverter();
//        List<Room> rooms = roomDtoConverter.transform(dto.getRooms());
//        entity.setRooms(rooms);
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setHotelRating(dto.getHotelRating());
    }
}
