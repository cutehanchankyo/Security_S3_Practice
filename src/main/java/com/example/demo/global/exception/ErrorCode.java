package com.example.demo.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    MANY_REQUEST_EMAIL_AUTH("이메일은 15분에 최대 3회까지만 발송됩니다", 429),
    EMAIL_SEND_FAIL("메일 발송에 실패했습니다", 500),
    AUTH_CODE_MISMATCH("인증번호가 일치하지 않습니다", 400);

    private final String message;
    private final int status;
}
