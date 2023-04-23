package com.example.demo.domain.comment.service.Impl;

import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.exception.CommentNotFoundException;
import com.example.demo.domain.comment.exception.CommentUserMismatchException;
import com.example.demo.domain.comment.repository.CommentRepository;
import com.example.demo.domain.comment.service.DeleteCommentService;
import com.example.demo.domain.user.entity.User;
import com.example.demo.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCommentServiceImpl implements DeleteCommentService {
    private final CommentRepository commentRepository;
    private final UserUtil userUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void execute(Long commentId) {
        User user = userUtil.currentUser();
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("댓글을 찾을 수 없습니다"));

        if(!comment.getUser().equals(user))
            throw new CommentUserMismatchException("댓글의 작성자가 아닙니다");

        commentRepository.delete(comment);
    }
}
