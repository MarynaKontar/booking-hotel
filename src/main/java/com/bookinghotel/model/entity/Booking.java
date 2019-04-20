package com.bookinghotel.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Booking extends AbstractEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;
    @OneToOne(fetch = FetchType.EAGER)
    private Room room;
    private LocalDate arrival;
    private LocalDate departure;
    private BigDecimal totalPrice;
//    private BigDecimal advancePayment; //аванс


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
