package com.autocrypt.autocrypt.login.service;

import com.autocrypt.autocrypt.login.dto.SignUpRequestDto;
import com.autocrypt.autocrypt.login.repository.UserRepository;
import com.autocrypt.autocrypt.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public String registerUser(SignUpRequestDto requestDto) {

        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String nickname = requestDto.getNickname();

        Optional<User> foundUserName = userRepository.findByUsername(username);
        Optional<User> foundNickName = userRepository.findByNickname(nickname);

        if(foundUserName.isPresent()){
            return "이미 존재하는 아이디입니다.";
        }
        if(foundNickName.isPresent()){
            return "이미 존재하는 닉네임입니다.";
        }

        User user = new User(username, password, nickname);
        userRepository.save(user);

        return "회원가입을 환영합니다";
    }
}
