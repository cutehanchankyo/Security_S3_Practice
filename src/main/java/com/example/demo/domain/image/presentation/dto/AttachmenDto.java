package com.example.demo.domain.image.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AttachmenDto {
    private String originFileName;
    private String filePath;
    private Long fileSize;
}
