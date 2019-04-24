package com.bookinghotel.exception;

import lombok.Getter;
import lombok.NonNull;

@Getter
public abstract class ServiceException extends RuntimeException {

    @NonNull
    private String error;

    @NonNull
    private int errorCode;

    public ServiceException(@NonNull String error, @NonNull int errorCode, @NonNull String message) {
        super(message);
        this.error = error;
        this.errorCode = errorCode;
    }
}