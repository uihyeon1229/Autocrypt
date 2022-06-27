package com.autocrypt.autocrypt.board.service;

import com.autocrypt.autocrypt.board.dto.BoardDetailResponseDto;
import com.autocrypt.autocrypt.board.dto.BoardRequestDto;
import com.autocrypt.autocrypt.board.dto.BoardResponseDto;
import com.autocrypt.autocrypt.board.repository.BoardRepository;
import com.autocrypt.autocrypt.model.Board;
import com.autocrypt.autocrypt.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    //게시판 글 작성
    public BoardResponseDto saveBoard(BoardRequestDto requestDto, UserDetailsImpl userDetails) {
        Board board = new Board(requestDto,userDetails);
        boardRepository.save(board);

        return new BoardResponseDto(userDetails,board);
    }

    public List<BoardResponseDto> findAll(UserDetailsImpl userDetails) {

        List<Board> allBoard = boardRepository.findAllByOrderByCreatedAtDesc();

        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();

        for(Board board : allBoard){
            boardResponseDtos.add(new BoardResponseDto(board));
        }
        return boardResponseDtos;
    }
    //게시글 조회
    public BoardDetailResponseDto detail(Long boardId, UserDetailsImpl userDetails) {
        Board board = boardRepository.findByBoardId(boardId);
        return new BoardDetailResponseDto(board);
    }

    //게시글 수정
    @Transactional
    public BoardDetailResponseDto editBoard(Long boardId, BoardRequestDto requestDto, UserDetailsImpl userDetails) {
        Board board = boardRepository.findByBoardId(boardId);
        if(board.getUser().getUserId() != userDetails.getUser().getUserId()){
            throw new IllegalArgumentException("수정 권한 ERROR!");
        }
        board.edit(requestDto,userDetails);

        return new BoardDetailResponseDto(board);
    }

    @Transactional
    public void deleteBoard(Long boardId, UserDetailsImpl userDetails) {
        Board board = boardRepository.findByBoardId(boardId);
        if(board.getUser().getUserId() != userDetails.getUser().getUserId()){
            throw new IllegalArgumentException("삭제 권한 ERROR!");
        }
        boardRepository.deleteById(boardId);
    }
}
