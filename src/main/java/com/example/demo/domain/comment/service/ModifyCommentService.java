package com.example.demo.domain.comment.service;

import com.example.demo.domain.comment.presentation.dto.request.ModifyCommentReqDto;

public interface ModifyCommentService {
    void execute(Long commentId, ModifyCommentReqDto modifyCommentReqDto);
}
