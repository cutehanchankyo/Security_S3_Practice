package com.example.demo.domain.user.exception;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class WrongPasswordException extends RuntimeException{
    private final ErrorCode errorCode;

    public WrongPasswordException(String message) {
        super(message);
        this.errorCode = ErrorCode.WRONG_PASSWORD;
    }
}