package com.example.demo.domain.comment.exception;

import com.example.demo.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class CommentUserMismatchException extends RuntimeException {
    private final ErrorCode errorCode;

    public CommentUserMismatchException(String message) {
        super(message);
        this.errorCode = ErrorCode.COMMENT_USER_MISMATCH;
    }
}