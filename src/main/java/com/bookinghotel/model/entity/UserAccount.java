package com.bookinghotel.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserAccount extends AbstractEntity {
    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    @OneToMany(mappedBy = "userAccount", orphanRemoval = true)
    private List<Booking> bookings;

    /**
     * Method add {@link Booking} to {@link UserAccount} according to bidirectional @OneToMany mapping with orphanRemoval = true
     * @param booking for adding to {@link UserAccount}
     */
    public void addBooking(Booking booking) {
        if (bookings == null || bookings.isEmpty()) {
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setUserAccount(this);
    }
    /**
     * Method remove {@link Booking} from {@link UserAccount} according to bidirectional @OneToMany mapping with orphanRemoval = true
     * @param booking for removing from {@link UserAccount}
     */
    public void removeBooking (Booking booking) {
        if (bookings != null)
            bookings.remove(booking);
        booking.setUserAccount(null);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "user=" + user +
                '}';
    }
}
