package com.autocrypt.autocrypt.board.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String boardTitle;
    private String boardContent;
    private boolean secret;

}
