package com.example.demo.domain.image.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    List<String> execute(List<MultipartFile> multipartFiles);
}
