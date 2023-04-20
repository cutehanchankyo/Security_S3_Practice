package com.example.demo.domain.user.exception;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicatedUserClassNumException extends RuntimeException{
    private final ErrorCode errorCode;

    public DuplicatedUserClassNumException(String message) {
        super(message);
        this.errorCode = ErrorCode.CLASS_NUMBER_ALREADY_EXIST;
    }
}
