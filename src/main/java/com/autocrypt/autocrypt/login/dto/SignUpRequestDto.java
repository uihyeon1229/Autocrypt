package com.autocrypt.autocrypt.login.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String username;
    private String password;
    private String nickname;
}
