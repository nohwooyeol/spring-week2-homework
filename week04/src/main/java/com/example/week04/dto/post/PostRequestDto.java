package com.example.week04.dto.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor //의존성을 주입하기 위해
@Getter //getter 자동생성
@Setter //setter 자동생성
public class PostRequestDto {
    private final String title;
    private final String author;
    private final String password;
    private final String content;
}