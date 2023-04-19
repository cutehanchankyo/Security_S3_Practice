package com.example.demo.domain.email.repository;

import com.example.demo.domain.email.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, String> {
}
