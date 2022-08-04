package com.example.week04.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter //getter 자동생성
@Setter //setter 자동생성
public class PostResponseDto<T> {

    private boolean success;

    private T data;

    private String error;

    public PostResponseDto(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }
}
