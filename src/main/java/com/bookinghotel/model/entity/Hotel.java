package com.bookinghotel.model.entity;

import com.bookinghotel.model.enums.HotelRating;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Hotel extends AbstractEntity {
    private String name;
    private String city;
    @Enumerated(EnumType.ORDINAL)
    private HotelRating hotelRating;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;

    /**
     * Method add {@link Room} to {@link Hotel} according to bidirectional @OneToMany mapping with orphanRemoval = true
     * @param room for adding to {@link Hotel}
     */
    public void addRoom(Room room) {
        if (rooms == null) {
            rooms = new ArrayList<>(0);
        }
        rooms.add(room);
        room.setHotel(this);
    }
    /**
     * Method remove {@link Room} from {@link Hotel} according to bidirectional @OneToMany mapping with orphanRemoval = true
     * @param room for removing from {@link Hotel}
     */
    public void removeRoom (Room room) {
        if (rooms != null)
        rooms.remove(room);
        room.setHotel(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) &&
                Objects.equals(city, hotel.city) &&
                hotelRating == hotel.hotelRating &&
                Objects.equals(rooms, hotel.rooms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, city, hotelRating, rooms);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", hotelRating=" + hotelRating +
                '}';
    }
}
