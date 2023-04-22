package com.example.demo.domain.post.service;

import com.example.demo.domain.post.presentation.dto.request.CreatePostRequest;

public interface CreatePostService {
    void execute(CreatePostRequest createPostRequest);
}
