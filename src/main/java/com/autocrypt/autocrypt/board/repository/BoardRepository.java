package com.autocrypt.autocrypt.board.repository;

import com.autocrypt.autocrypt.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByCreatedAtDesc();

    Board findByBoardId(Long boardId);
}
