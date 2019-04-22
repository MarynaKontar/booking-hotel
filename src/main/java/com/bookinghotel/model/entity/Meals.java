package com.bookinghotel.model.entity;

import com.bookinghotel.model.enums.MealsType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Embeddable
public class Meals {
    @Enumerated(EnumType.STRING)
    private MealsType mealsType;
    @Column(name="mealPrice")
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Meals meals = (Meals) o;
        return mealsType == meals.mealsType &&
                Objects.equals(price, meals.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), mealsType, price);
    }
}
