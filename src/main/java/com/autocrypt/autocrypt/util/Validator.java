package com.autocrypt.autocrypt.util;

import com.autocrypt.autocrypt.board.repository.BoardRepository;
import com.autocrypt.autocrypt.login.dto.SignUpRequestDto;
import com.autocrypt.autocrypt.login.repository.UserRepository;
import com.autocrypt.autocrypt.model.Board;
import com.autocrypt.autocrypt.model.User;
import com.autocrypt.autocrypt.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Validator {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public void boardAuthCheck(Long boardId, UserDetailsImpl userDetails){
        Board board = getBoard(boardId);
        if(!Objects.equals(board.getUser().getUserId(), userDetails.getUser().getUserId())){
            throw new IllegalArgumentException("권한이 없습니다.");
        }
    }

    public void secretCheck(Long boardId, UserDetailsImpl userDetails) {
        Board board = getBoard(boardId);
        if(board.isSecret() && !Objects.equals(board.getUser().getUserId(), userDetails.getUser().getUserId())){
            throw new IllegalArgumentException("비밀글은 본인만 확인할 수 있습니다.");
        }
    }

    public void usernameCheck(SignUpRequestDto requestDto) {
        Optional<User> foundUserName = userRepository.findByUsername(requestDto.getUsername());
        if(foundUserName.isPresent()){
            throw new IllegalArgumentException("이미 사용중인 username입니다.");
        }
    }

    public void nicknameCheck(SignUpRequestDto requestDto) {
        Optional<User> foundNickName = userRepository.findByNickname(requestDto.getNickname());
        if(foundNickName.isPresent()){
            throw new IllegalArgumentException("이미 사용중인 nickname입니다.");
        }
    }

    public Board getBoard(Long boardId){
        return boardRepository.findByBoardId(boardId);
    }

}
