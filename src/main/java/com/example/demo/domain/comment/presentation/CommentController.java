package com.example.demo.domain.comment.presentation;

import com.example.demo.domain.comment.presentation.dto.request.CreateCommentReqDto;
import com.example.demo.domain.comment.service.CreateCommentService;
import com.example.demo.domain.comment.service.DeleteCommentService;
import com.example.demo.domain.comment.service.ModifyCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CreateCommentService createCommentService;
    private final ModifyCommentService modifyCommentService;
    private final DeleteCommentService deleteCommentService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> createComment(@PathVariable Long postId, @RequestBody @Valid CreateCommentReqDto createCommentReqDto) {
        createCommentService.execute(postId, createCommentReqDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}