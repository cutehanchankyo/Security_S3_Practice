package com.example.demo.domain.email.service;

import com.example.demo.domain.email.entity.Email;
import com.example.demo.domain.email.exception.AuthCodeMismatchException;
import com.example.demo.domain.email.exception.EmailSendFailedException;
import com.example.demo.domain.email.exception.ManyRequestEmailAuthException;
import com.example.demo.domain.email.presentation.dto.EmailSendRequest;
import com.example.demo.domain.email.repository.EmailRepository;
import com.example.demo.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;


    @Override
    public void execute(String email, String authKey) {
        Email emailAuth = emailRepository.findById(email).orElseThrow(() -> new UserNotFoundException("유저를 찾을 수 없습니다"));
        checkAuthKey(emailAuth, authKey);
        emailAuth.updateAuthentication(true);
        emailRepository.save(emailAuth);
    }

    private void checkAuthKey(Email email, String authKey) {
        if(!Objects.equals(email.getRandomValue(), authKey))
            throw new AuthCodeMismatchException("인증번호가 일치하지 않습니다");
    }

    @Transactional(rollbackFor = Exception.class)
    public void execute(EmailSendRequest emailSendRequest) {
        Random random = new Random();
        String authKey = String.valueOf(random.nextInt(8888)+1111);

        sendAuthEmail(emailSendRequest.getEmail(), authKey);
    }

    private void sendAuthEmail(String email, String authKey) {
        String subject = "GFO 인증번호";
        String content = "회원 가입을 위한 인증번호는" + authKey + "입니다 <br />";
        Email emailAuth = Email.builder()
                .email(email)
                .randomValue(authKey)
                .attemptCount(0)
                .authentication(false)
                .build();
        if(emailAuth.getAttemptCount() >= 3) {
            throw new ManyRequestEmailAuthException("이메일은 15분에 최대 3회까지 요청 가능합니다");
        }
        emailAuth.updateRandomValue(authKey);
        emailAuth.increaseAttemptCount();

        emailRepository.save(emailAuth);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(content,true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new EmailSendFailedException("이메일 발송에 실패하였습니다");
        }
    }
}
