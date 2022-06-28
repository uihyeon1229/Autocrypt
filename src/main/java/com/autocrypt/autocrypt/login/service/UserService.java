package com.autocrypt.autocrypt.login.service;

import com.autocrypt.autocrypt.login.dto.SignUpRequestDto;
import com.autocrypt.autocrypt.login.repository.UserRepository;
import com.autocrypt.autocrypt.model.User;
import com.autocrypt.autocrypt.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final Validator validator;


    public String registerUser(SignUpRequestDto requestDto) {

        validator.usernameCheck(requestDto);
        validator.nicknameCheck(requestDto);

        User user = new User(requestDto.getUsername(),
                            passwordEncoder.encode(requestDto.getPassword()),
                            requestDto.getNickname());

        userRepository.save(user);

        return "SUCCESS!";
    }
}
