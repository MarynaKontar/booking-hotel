package com.bookinghotel.model.entity;

import com.bookinghotel.model.enums.HotelRating;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", hotelRating=" + hotelRating +
                '}';
    }
}
