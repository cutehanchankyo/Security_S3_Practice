package com.example.demo.domain.post.service.Impl;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.exception.EmailMismatchException;
import com.example.demo.domain.post.exception.PostNotFoundException;
import com.example.demo.domain.post.repository.PostRepository;
import com.example.demo.domain.post.service.RemovePostService;
import com.example.demo.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemovePostServiceImpl implements RemovePostService {
    private final PostRepository postRepository;
    private final UserUtil userUtil;

    @Override
    public void execute(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("게시물을 찾을 수 없습니다"));
        if((post.getUser().getEmail().equals(userUtil.currentUser().getEmail()))) {
            postRepository.deleteById(id);
        }
        else {
            throw new EmailMismatchException("이메일이 일치하지 않습니다");
        }
    }
}