package com.bookinghotel.converter.dto;

import com.bookinghotel.model.dto.UserDto;
import com.bookinghotel.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter extends AbstractDtoConverter<User, UserDto> {
    @Override
    protected UserDto createNewDto() {
        return new UserDto();
    }

    @Override
    protected User createNewEntity() {
        return new User();
    }

    @Override
    protected void convertFromEntity(User entity, UserDto dto) {
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());
    }

    @Override
    protected void convertFromDto(UserDto dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }
}
