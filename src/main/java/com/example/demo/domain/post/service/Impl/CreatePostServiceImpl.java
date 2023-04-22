package com.example.demo.domain.post.service.Impl;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.presentation.dto.request.CreatePostRequest;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.domain.post.service.CreatePostService;
import com.example.demo.domain.user.entity.User;
import com.example.demo.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreatePostServiceImpl implements CreatePostService {
    private final UserUtil userUtil;
    private final PostRepository postRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void execute(CreatePostRequest createPostRequest) {
        User user = userUtil.currentUser();

        Post post = Post.builder()
                .title(createPostRequest.getTitle())
                .content(createPostRequest.getContent())
                .user(user)
                .build();

        postRepository.save(post);
    }
}