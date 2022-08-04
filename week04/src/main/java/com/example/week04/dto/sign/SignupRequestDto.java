package com.example.week04.dto.sign;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
public class SignupRequestDto {

    private String nickname;

    private String password;

    private String passwordConfirm;
}
