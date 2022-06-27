package com.autocrypt.autocrypt.util;

import com.autocrypt.autocrypt.board.repository.BoardRepository;
import com.autocrypt.autocrypt.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class validator {
    private final BoardService boardService;
    private final BoardRepository boardRepository;


}
