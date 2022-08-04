package com.example.week04.dto.post;

import com.example.week04.model.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@RequiredArgsConstructor //의존성을 주입하기 위해
@Getter //getter 자동생성
@Setter //setter 자동생성
public class PostDataDto {

    private final LocalDateTime createdAt;

    private final LocalDateTime modifiedAt;

    private final Long id;

    private final String title;

    private final String content;

    private final String author;

    public PostDataDto(Post post) {
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }


}
