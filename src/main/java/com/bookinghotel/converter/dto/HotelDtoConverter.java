package com.bookinghotel.converter.dto;

import com.bookinghotel.model.dto.HotelDto;
import com.bookinghotel.model.entity.Hotel;
import org.springframework.stereotype.Component;

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
        dto.setCity(entity.getCity());
        dto.setName(entity.getName());
        dto.setHotelRating(entity.getHotelRating());
    }

    @Override
    protected void convertFromDto(HotelDto dto, Hotel entity) {
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setHotelRating(dto.getHotelRating());
    }
}
