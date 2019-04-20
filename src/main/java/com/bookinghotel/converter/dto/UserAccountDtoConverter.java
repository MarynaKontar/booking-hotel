package com.bookinghotel.converter.dto;

import com.bookinghotel.model.dto.BookingDto;
import com.bookinghotel.model.dto.UserAccountDto;
import com.bookinghotel.model.dto.UserDto;
import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.User;
import com.bookinghotel.model.entity.UserAccount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAccountDtoConverter extends AbstractDtoConverter<UserAccount, UserAccountDto> {
    @Override
    protected UserAccountDto createNewDto() {
        return new UserAccountDto();
    }

    @Override
    protected UserAccount createNewEntity() {
        return new UserAccount();
    }

    @Override
    protected void convertFromEntity(UserAccount entity, UserAccountDto dto) {
        UserDtoConverter userDtoConverter = new UserDtoConverter();
        BookingDtoConverter bookingDtoConverter = new BookingDtoConverter();
        UserDto userDto = userDtoConverter.transform(entity.getUser());
        List<BookingDto> bookingDtos = bookingDtoConverter.transform(entity.getBookings());
        dto.setUser(userDto);
        dto.setBookings(bookingDtos);
    }

    @Override
    protected void convertFromDto(UserAccountDto dto, UserAccount entity) {
        UserDtoConverter userDtoConverter = new UserDtoConverter();
        BookingDtoConverter bookingDtoConverter = new BookingDtoConverter();
        User user = userDtoConverter.transform(dto.getUser());
        List<Booking> bookings = bookingDtoConverter.transform(dto.getBookings());
        entity.setUser(user);
        entity.setBookings(bookings);
    }
}
