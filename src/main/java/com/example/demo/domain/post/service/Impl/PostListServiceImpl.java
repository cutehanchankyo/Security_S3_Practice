package com.example.demo.domain.post.service.Impl;

import com.example.demo.domain.post.presentation.dto.response.PostListResDto;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.domain.post.service.PostListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostListServiceImpl implements PostListService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PostListResDto> execute() {
        return postRepository.findAll().stream()
                .map(post -> new PostListResDto(
                        post.getPostId(),
                        post.getTitle(),
                        post.getUser().getEmail(),
                        post.getUser().getName()
                )).collect(Collectors.toList());
    }
}