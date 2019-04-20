package com.bookinghotel.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Data
@Embeddable
public class Cleaning {
    @Column(name="cleaningPrice")
    private BigDecimal price;
}
