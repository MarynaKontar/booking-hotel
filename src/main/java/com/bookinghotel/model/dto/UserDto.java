package com.bookinghotel.model.dto;

import com.bookinghotel.model.enums.UserRole;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class UserDto extends AbstractDto {
    private String name;
    @Email
    private String email;
    private UserRole role;
}
