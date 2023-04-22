package com.example.demo.domain.comment.service;

import com.example.demo.domain.comment.presentation.dto.request.CreateCommentReqDto;

public interface CreateCommentService {
    void execute(Long postId, CreateCommentReqDto createCommentReqDto);
}
