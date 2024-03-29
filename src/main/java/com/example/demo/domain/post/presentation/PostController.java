package com.example.demo.domain.post.presentation;

import com.example.demo.domain.post.presentation.dto.request.CreatePostRequest;
import com.example.demo.domain.post.presentation.dto.request.ModifyPostRequest;
import com.example.demo.domain.post.presentation.dto.response.PostDetailResponse;
import com.example.demo.domain.post.presentation.dto.response.PostListResDto;
import com.example.demo.domain.post.service.*;
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
    private final OnePostService onePostService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody @Valid CreatePostRequest createPostRequest) {
        createPostService.execute(createPostRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> modifyPost(@PathVariable Long id,  @RequestBody @Valid ModifyPostRequest modifyPostRequest) {
        modifyPostService.execute(id, modifyPostRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePost(@PathVariable Long id) {
        removePostService.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<PostListResDto>> findAllPost() {
        List<PostListResDto> results = postListService.execute();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailResponse> findOne(@PathVariable("id") Long id){
        PostDetailResponse oneFindById = onePostService.execute(id);
        return new ResponseEntity<>(oneFindById,HttpStatus.OK);
    }

}
