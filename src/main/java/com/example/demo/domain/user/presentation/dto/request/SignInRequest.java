package com.example.demo.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class SignInRequest {
    @Email
    @NotBlank(message = "이메일은 필수 입력값입니다")
    private final String email;
    @NotBlank(message = "비밀번호는 필수 입력값입니다")
    private final String password;

}