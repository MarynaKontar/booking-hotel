package com.bookinghotel.converter.dto;

import com.bookinghotel.model.dto.HotelDto;
import com.bookinghotel.model.dto.RoomDto;
import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.model.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomDtoConverter extends AbstractDtoConverter<Room, RoomDto> {
    @Override
    protected RoomDto createNewDto() {
        return new RoomDto();
    }

    @Override
    protected Room createNewEntity() {
        return new Room();
    }

    @Override
    protected void convertFromEntity(Room entity, RoomDto dto) {
        HotelDtoConverter hotelDtoConverter = new HotelDtoConverter();
        HotelDto hotelDto = hotelDtoConverter.transform(entity.getHotel());
        dto.setHotel(hotelDto);
        dto.setCategory(entity.getCategory());
        dto.setNumber(entity.getNumber());
        dto.setPrice(entity.getPrice());
        dto.setBreakfast(entity.getBreakfast());
        dto.setCleaningWithAdditionalCost(entity.getCleaningWithAdditionalCost());
    }

    @Override
    protected void convertFromDto(RoomDto dto, Room entity) {
        HotelDtoConverter hotelDtoConverter = new HotelDtoConverter();
        Hotel hotel = hotelDtoConverter.transform(dto.getHotel());
        entity.setHotel(hotel);
        entity.setCategory(dto.getCategory());
        entity.setNumber(dto.getNumber());
        entity.setPrice(dto.getPrice());
        entity.setBreakfast(dto.getBreakfast());
        entity.setCleaningWithAdditionalCost(dto.getCleaningWithAdditionalCost());
    }
}
