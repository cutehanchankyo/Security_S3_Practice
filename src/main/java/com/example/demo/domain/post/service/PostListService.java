package com.example.demo.domain.post.service;

import com.example.demo.domain.post.presentation.dto.response.PostListResDto;

import java.util.List;

public interface PostListService {
    List<PostListResDto> execute();
}
