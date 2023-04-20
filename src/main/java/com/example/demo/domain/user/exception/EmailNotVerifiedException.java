package com.example.demo.domain.user.exception;



import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class EmailNotVerifiedException extends RuntimeException{
    private final ErrorCode errorCode;

    public EmailNotVerifiedException(String message) {
        super(message);
        this.errorCode = ErrorCode.EMAIL_NOT_VERIFIED;
    }
}