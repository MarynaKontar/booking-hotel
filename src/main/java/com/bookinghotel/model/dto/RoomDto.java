package com.bookinghotel.model.dto;

import com.bookinghotel.model.entity.Cleaning;
import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.model.entity.Meals;
import com.bookinghotel.model.enums.RoomCategory;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
public class RoomDto extends AbstractDto {
    private Integer number;
    private RoomCategory category;
    private BigDecimal price;
    private Meals breakfast;
    private Cleaning cleaningWithAdditionalCost;
    private HotelDto hotel;
}
