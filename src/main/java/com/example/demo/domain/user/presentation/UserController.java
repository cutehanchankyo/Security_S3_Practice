package com.example.demo.domain.user.presentation;

import com.example.demo.domain.user.presentation.dto.request.SignInRequest;
import com.example.demo.domain.user.presentation.dto.request.SignUpRequest;
import com.example.demo.domain.user.presentation.dto.response.NewTokenResponse;
import com.example.demo.domain.user.presentation.dto.response.SignInResponse;
import com.example.demo.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignUpRequest signupRequest) {
        userService.signUp(signupRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<SignInResponse> signIn(@Valid @RequestBody SignInRequest signinRequest) {
        SignInResponse data = userService.signIn(signinRequest);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> logout(@RequestHeader("Authorization")String accessToken){
        userService.logout(accessToken);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping
    public ResponseEntity<NewTokenResponse> renewToken(@RequestHeader("RefreshToken")String refreshToken) {
        NewTokenResponse newTokenResponse = userService.tokenReissue(refreshToken);
        return new ResponseEntity<>(newTokenResponse, HttpStatus.OK);
    }
}