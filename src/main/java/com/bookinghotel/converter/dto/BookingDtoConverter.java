package com.bookinghotel.converter.dto;

import com.bookinghotel.model.dto.BookingDto;
import com.bookinghotel.model.dto.RoomDto;
import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class BookingDtoConverter extends AbstractDtoConverter<Booking, BookingDto> {
    @Override
    protected BookingDto createNewDto() {
        return new BookingDto();
    }

    @Override
    protected Booking createNewEntity() {
        return new Booking();
    }

    @Override
    protected void convertFromEntity(Booking entity, BookingDto dto) {
        RoomDtoConverter roomDtoConverter = new RoomDtoConverter();
        RoomDto roomDto = roomDtoConverter.transform(entity.getRoom());
        dto.setRoom(roomDto);
        dto.setTotalPrice(entity.getTotalPrice());
        dto.setCheckIn(entity.getArrival());
        dto.setCheckOut(entity.getDeparture());
    }

    @Override
    protected void convertFromDto(BookingDto dto, Booking entity) {
//        UserAccountDtoConverter userAccountDtoConverter = new UserAccountDtoConverter();
        RoomDtoConverter roomDtoConverter = new RoomDtoConverter();
//        UserAccount userAccount = userAccountDtoConverter.transform(dto.getUserAccount());
        Room room = roomDtoConverter.transform(dto.getRoom());
//        entity.setUserAccount(userAccount);
        entity.setRoom(room);
        entity.setTotalPrice(dto.getTotalPrice());
        entity.setArrival(dto.getCheckIn());
        entity.setDeparture(dto.getCheckOut());
    }
}
