package com.example.week04.dto.sign;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto<T> {
    private boolean success;

    private T data;

    private String error;

    public SignupResponseDto(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }


}
