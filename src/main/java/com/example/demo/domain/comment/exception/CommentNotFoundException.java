package com.example.demo.domain.comment.exception;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class CommentNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public CommentNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.EMAIL_NOT_FOUND;
    }
}