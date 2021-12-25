package com.example.communitywebservice.board.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
    BoardEntity findByWriter(String writer);
}
