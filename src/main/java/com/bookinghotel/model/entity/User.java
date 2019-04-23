package com.bookinghotel.model.entity;

import com.bookinghotel.model.enums.UserRole;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@Entity
public class User extends AbstractEntity {

    @NotEmpty
    private String name;
    @Email
    @Column(unique = true)
    @NotNull
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                role == user.role;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, email, role);
    }
}
