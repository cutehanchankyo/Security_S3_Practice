package com.example.demo.domain.post.service.Impl;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.exception.PostNotFoundException;
import com.example.demo.domain.post.presentation.dto.response.PostDetailResponse;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.domain.post.service.OnePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OnePostServiceImpl implements OnePostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    @Override
    public PostDetailResponse execute(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("게시물을 찾을수 없습니다"));

        PostDetailResponse noticeDetailResponse = PostDetailResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();

        return noticeDetailResponse;
    }
}
