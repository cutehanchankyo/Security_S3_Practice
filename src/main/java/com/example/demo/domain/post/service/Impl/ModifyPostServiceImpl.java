package com.example.demo.domain.post.service.Impl;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.exception.PostNotFoundException;
import com.example.demo.domain.post.presentation.dto.request.ModifyPostRequest;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.domain.post.service.ModifyPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyPostServiceImpl implements ModifyPostService {
    private final PostRepository postRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void execute(Long id, ModifyPostRequest modifyPostRequest) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("게시글을 찾을 수 없습니다"));
        post.modifyPost(modifyPostRequest);
    }
}