package com.example.demo.domain.post.exception;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class EmailMismatchException extends RuntimeException{
    private final ErrorCode errorCode;

    public EmailMismatchException(String message) {
        super(message);
        this.errorCode = ErrorCode.EMAIL_MISMATCH;
    }
}
