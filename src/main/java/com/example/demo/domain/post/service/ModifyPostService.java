package com.example.demo.domain.post.service;

import com.example.demo.domain.post.presentation.dto.request.ModifyPostRequest;

public interface ModifyPostService {
    void execute(Long id, ModifyPostRequest modifyPostRequest);
}
