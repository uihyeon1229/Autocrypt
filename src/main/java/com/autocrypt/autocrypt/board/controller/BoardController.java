package com.autocrypt.autocrypt.board.controller;

import com.autocrypt.autocrypt.board.dto.BoardRequestDto;
import com.autocrypt.autocrypt.board.dto.BoardResponseDto;
import com.autocrypt.autocrypt.board.service.BoardService;
import com.autocrypt.autocrypt.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    //게시판 글 작성
    @PostMapping("/board/write")
    public BoardResponseDto save(
            @RequestBody BoardRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails){
        return boardService.saveBoard(requestDto,userDetails);
    }

    //게시판 조회
    @GetMapping("/boards")
    public List<BoardResponseDto> findAll(){
        return boardService.findAll();
    }

    //게시글 상세조회
    @GetMapping("/board/{boardId}")
    public BoardResponseDto detail(@PathVariable("boardId") Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return boardService.detail(boardId,userDetails);
    }

    //게시글 수정
    @PutMapping("/board/{boardId}")
    public BoardResponseDto editBoard(@PathVariable("boardId") Long boardId, @RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return boardService.editBoard(boardId,requestDto,userDetails);
    }

    //게시글 삭제
    @DeleteMapping("/board/{boardId}")
    public void deleteBoard(@PathVariable("boardId") Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        boardService.deleteBoard(boardId,userDetails);
    }

}