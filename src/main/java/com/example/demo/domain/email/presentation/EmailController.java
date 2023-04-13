package com.example.demo.domain.email.presentation;

import com.example.demo.domain.email.presentation.dto.EmailSendRequest;
import com.example.demo.domain.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> sendEmail(@RequestBody @Valid EmailSendRequest emailSendRequest) {
        emailService.execute(emailSendRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Void> authEmail(@Email @RequestParam String email, @RequestParam String authKey){
        emailService.execute(email,authKey);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
