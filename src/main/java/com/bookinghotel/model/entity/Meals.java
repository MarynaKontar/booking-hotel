package com.bookinghotel.model.entity;

import com.bookinghotel.model.enums.MealsType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@Embeddable
public class Meals {
    @Enumerated(EnumType.STRING)
    private MealsType mealsType;
    @Column(name="mealPrice")
    private BigDecimal price;
}
