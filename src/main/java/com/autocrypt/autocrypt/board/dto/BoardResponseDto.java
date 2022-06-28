package com.autocrypt.autocrypt.board.dto;

import com.autocrypt.autocrypt.model.Board;
import com.autocrypt.autocrypt.security.UserDetailsImpl;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardResponseDto {
    private Long userId;
    private Long boardId;
    private String nickname;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime createdAt;
    private boolean secret;

    public BoardResponseDto(UserDetailsImpl userDetails, Board board) {
        this.userId = userDetails.getUser().getUserId();
        this.boardId = board.getBoardId();
        this.nickname = userDetails.getNickname();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.createdAt = board.getCreatedAt();
        this.secret = board.isSecret();
    }

    public BoardResponseDto(Board board) {
        this.userId = board.getUser().getUserId();
        this.boardId = board.getBoardId();
        this.nickname = board.getUser().getNickname();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.createdAt = board.getCreatedAt();
        this.secret = board.isSecret();
    }
}
