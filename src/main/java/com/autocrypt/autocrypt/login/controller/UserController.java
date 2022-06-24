package com.autocrypt.autocrypt.login.controller;


import com.autocrypt.autocrypt.login.dto.SignUpRequestDto;
import com.autocrypt.autocrypt.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signUp")
    public String signup(@RequestBody SignUpRequestDto requestDto) {
        return userService.registerUser(requestDto);
    }

}
