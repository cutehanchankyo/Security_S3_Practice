package com.example.demo.domain.post.entity;

import com.example.demo.domain.post.presentation.dto.request.ModifyPostRequest;
import com.example.demo.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "email")
    private User user;

    public void modifyPost(ModifyPostRequest modifyPostRequest) {
        this.title = modifyPostRequest.getTitle();
        this.content = modifyPostRequest.getContent();
    }
}
