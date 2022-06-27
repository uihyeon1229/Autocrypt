package com.autocrypt.autocrypt.board.dto;

import com.autocrypt.autocrypt.model.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDetailResponseDto {
    private Long userId;
    private Long boardId;
    private String nickname;
    private String boardTitle;
    private String boardContent;

    public BoardDetailResponseDto(Board board) {
        this.userId = board.getUser().getUserId();
        this.boardId = board.getBoardId();
        this.nickname = board.getUser().getNickname();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
    }
}
