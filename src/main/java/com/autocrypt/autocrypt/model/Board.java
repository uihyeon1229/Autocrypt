package com.autocrypt.autocrypt.model;

import com.autocrypt.autocrypt.board.dto.BoardRequestDto;
import com.autocrypt.autocrypt.security.UserDetailsImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Board extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false)
    private String boardContent;

    @Column(nullable = false)
    private boolean secret;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="userid")
    private User user;

    public Board(BoardRequestDto requestDto, UserDetailsImpl userDetails) {

        this.boardTitle = requestDto.getBoardTitle();
        this.boardContent = requestDto.getBoardContent();
        this.user = userDetails.getUser();
        this.secret = requestDto.isSecret();

    }

    public void edit(BoardRequestDto requestDto, UserDetailsImpl userDetails) {
        this.boardTitle = requestDto.getBoardTitle();
        this.boardContent = requestDto.getBoardContent();
        this.user = userDetails.getUser();
        this.secret = requestDto.isSecret();
    }
}
