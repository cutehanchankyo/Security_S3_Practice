package com.example.demo.domain.post.exception;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class PostNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public PostNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.POST_NOT_FOUND;
    }
}
