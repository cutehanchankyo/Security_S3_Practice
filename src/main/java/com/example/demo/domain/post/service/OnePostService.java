package com.example.demo.domain.post.service;

import com.example.demo.domain.post.presentation.dto.response.PostDetailResponse;

public interface OnePostService {
    PostDetailResponse execute(Long id);
}
