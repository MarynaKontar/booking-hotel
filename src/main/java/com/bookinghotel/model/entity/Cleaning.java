package com.bookinghotel.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Embeddable
public class Cleaning {
    @Column(name="cleaningPrice")
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cleaning cleaning = (Cleaning) o;
        return Objects.equals(price, cleaning.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), price);
    }
}
