package com.bookinghotel.model.entity;

import com.bookinghotel.model.enums.UserRole;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
public class User extends AbstractEntity {

    private String name;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
