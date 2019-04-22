package com.bookinghotel.model.entity;


import com.bookinghotel.model.enums.RoomCategory;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return Objects.equals(number, room.number) &&
                category == room.category &&
                Objects.equals(price, room.price) &&
                Objects.equals(breakfast, room.breakfast) &&
                Objects.equals(cleaningWithAdditionalCost, room.cleaningWithAdditionalCost) &&
                Objects.equals(hotel, room.hotel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), number, category, price, breakfast, cleaningWithAdditionalCost, hotel);
    }

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
