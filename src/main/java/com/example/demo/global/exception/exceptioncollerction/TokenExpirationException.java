package com.example.demo.global.exception.exceptioncollerction;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class TokenExpirationException extends RuntimeException{
    private final ErrorCode errorCode;
    public TokenExpirationException(String message){
        super(message);
        this.errorCode = ErrorCode.TOKEN_EXPIRATION;
    }
}
