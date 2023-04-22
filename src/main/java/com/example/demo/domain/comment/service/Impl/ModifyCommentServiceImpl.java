package com.example.demo.domain.comment.service.Impl;

import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.exception.CommentNotFoundException;
import com.example.demo.domain.comment.exception.CommentUserMismatchException;
import com.example.demo.domain.comment.presentation.dto.request.ModifyCommentReqDto;
import com.example.demo.domain.comment.repository.CommentRepository;
import com.example.demo.domain.comment.service.ModifyCommentService;
import com.example.demo.domain.user.entity.User;
import com.example.demo.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifyCommentServiceImpl implements ModifyCommentService {
    private final CommentRepository commentRepository;
    private final UserUtil userUtil;

    @Override
    public void execute(Long commentId, ModifyCommentReqDto modifyCommentReqDto) {
        User user = userUtil.currentUser();
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("댓글을 찾을 수 없습니다"));

        if(!user.equals(comment.getUser()))
            throw new CommentUserMismatchException("댓글의 작성자가 아닙니다");

        commentRepository.save(comment.update(commentId, modifyCommentReqDto.getContent()));
    }
}