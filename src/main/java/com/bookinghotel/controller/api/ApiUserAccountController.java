package com.bookinghotel.controller.api;

import com.bookinghotel.converter.dto.UserAccountDtoConverter;
import com.bookinghotel.model.dto.UserAccountDto;
import com.bookinghotel.model.entity.UserAccount;
import com.bookinghotel.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Endpoints for {@link UserAccount}
 */
@RestController
@RequestMapping("account")
public class ApiUserAccountController {
    private final UserAccountService userAccountService;
    private final UserAccountDtoConverter userAccountDtoConverter;

    @Autowired
    public ApiUserAccountController(UserAccountService userAccountService, UserAccountDtoConverter userAccountDtoConverter) {
        this.userAccountService = userAccountService;
        this.userAccountDtoConverter = userAccountDtoConverter;
    }

    /**
     * Endpoint for saving {@link UserAccountDto}
     * @param userAccountDto dto of userAccount
     * @return saved userAccount in dto
     */
    @PostMapping
    public ResponseEntity<UserAccountDto> create(@RequestBody @NotNull @Valid UserAccountDto userAccountDto) {
        UserAccount userAccount = userAccountService.add(userAccountDtoConverter.transform(userAccountDto));
        return new ResponseEntity<>(userAccountDtoConverter.transform(userAccount), HttpStatus.CREATED);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HttpHeaders> handleException(RuntimeException ex, HttpServletRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("messageError", "Something wrong: " + ex.getMessage()
                + "; path: " + request.getServletPath());
        return ResponseEntity.badRequest().headers(httpHeaders).build();
    }
}
