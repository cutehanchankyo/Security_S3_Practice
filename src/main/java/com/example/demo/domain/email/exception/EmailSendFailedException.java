package com.example.demo.domain.email.exception;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class EmailSendFailedException extends RuntimeException{
    private final ErrorCode errorCode;

    public EmailSendFailedException(String message) {
        super(message);
        this.errorCode = ErrorCode.EMAIL_SEND_FAIL;
    }
}
