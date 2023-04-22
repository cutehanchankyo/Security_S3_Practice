package com.example.demo.domain.comment.service.Impl;

import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.presentation.dto.request.CreateCommentReqDto;
import com.example.demo.domain.comment.repository.CommentRepository;
import com.example.demo.domain.comment.service.CreateCommentService;
import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.exception.PostNotFoundException;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCommentServiceImpl implements CreateCommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserUtil userUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void execute(Long postId, CreateCommentReqDto createCommentReqDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new PostNotFoundException("게시글을 찾을 수 없습니다"));

        Comment comment = Comment.builder()
                .content(createCommentReqDto.getContent())
                .user(userUtil.currentUser())
                .post(post)
                .build();

        commentRepository.save(comment);
    }
}
