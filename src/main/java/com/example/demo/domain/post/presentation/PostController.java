package com.example.demo.domain.post.presentation;

import com.example.demo.domain.post.presentation.dto.request.CreatePostRequest;
import com.example.demo.domain.post.service.CreatePostService;
import com.example.demo.domain.post.service.ModifyPostService;
import com.example.demo.domain.post.service.PostListService;
import com.example.demo.domain.post.service.RemovePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final CreatePostService createPostService;
    private final ModifyPostService modifyPostService;
    private final RemovePostService removePostService;
    private final PostListService postListService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody @Valid CreatePostRequest createPostRequest) {
        createPostService.execute(createPostRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
