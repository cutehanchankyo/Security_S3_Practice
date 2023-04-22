package com.example.demo.domain.post.presentation.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostDetailResponse {
    private String title;

    private String content;
}
