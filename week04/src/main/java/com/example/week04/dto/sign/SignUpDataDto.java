package com.example.week04.dto.sign;

import lombok.Getter;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SignUpDataDto {

    private String nickname;

    private String password;

}
