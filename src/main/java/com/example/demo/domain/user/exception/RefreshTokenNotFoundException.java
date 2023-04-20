package com.example.demo.domain.user.exception;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class RefreshTokenNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public RefreshTokenNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.REFRESH_TOKEN_NOT_FOUND;
    }
}
