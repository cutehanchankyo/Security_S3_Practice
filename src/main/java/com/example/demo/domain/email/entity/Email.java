package com.example.demo.domain.email.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@Builder
@RedisHash(value = "emailAuth", timeToLive = 60 * 15)
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Id
    private String email;
    @Length(max = 4)
    private String randomValue;
    private Boolean authentication;
    @ColumnDefault("1")
    private Integer attemptCount;

    public void updateAuthentication(Boolean authentication) {
        this.authentication = authentication;
    }
    public void updateRandomValue(String uuid) {
        this.randomValue = uuid;
    }
    public void increaseAttemptCount() {
        attemptCount += 1;
    }
}
