package com.bookinghotel.model.entity;


import com.bookinghotel.model.enums.RoomCategory;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Room extends AbstractEntity{
    private Integer number;
    @Enumerated(EnumType.STRING)
    private RoomCategory category;
    private BigDecimal price;
    @Embedded
    private Meals breakfast;
    @Embedded
    private Cleaning cleaningWithAdditionalCost;
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", category=" + category +
                ", price=" + price +
                ", breakfast=" + breakfast +
                ", cleaningWithAdditionalCost=" + cleaningWithAdditionalCost +
                '}';
    }
}
