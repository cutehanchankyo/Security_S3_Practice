package com.example.demo.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.stereotype.Indexed;

import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RedisHash(value = "refeshToken")
public class RefreshToken {

    private String email;

    @Id
    private String token;

    @TimeToLive
    private Long expiredAt;

    public void exchangeRefreshToken(String token) {
        this.token = token;
    }
}
