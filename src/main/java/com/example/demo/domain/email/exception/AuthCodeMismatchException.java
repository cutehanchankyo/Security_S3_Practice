package com.example.demo.domain.email.exception;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class AuthCodeMismatchException extends RuntimeException{
    private final ErrorCode errorCode;

    public AuthCodeMismatchException(String message) {
        super(message);
        this.errorCode = ErrorCode.AUTH_CODE_MISMATCH;
    }
}
