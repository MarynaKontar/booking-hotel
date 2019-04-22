package com.bookinghotel.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
public class Booking extends AbstractEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userAccount_id")
    private UserAccount userAccount;
    @OneToOne(fetch = FetchType.EAGER)
    private Room room;
    private LocalDate arrival;
    private LocalDate departure;
    private BigDecimal totalPrice;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Booking booking = (Booking) o;
        return Objects.equals(userAccount, booking.userAccount) &&
                Objects.equals(room, booking.room) &&
                Objects.equals(arrival, booking.arrival) &&
                Objects.equals(departure, booking.departure) &&
                Objects.equals(totalPrice, booking.totalPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), userAccount, room, arrival, departure, totalPrice);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userAccount=" + userAccount.getId() +
                ", room=" + room.getId() +
                ", arrival=" + arrival +
                ", departure=" + departure +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
