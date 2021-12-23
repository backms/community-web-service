package com.example.communitywebservice.board.service;

import com.example.communitywebservice.board.dto.BoardDto;
import com.example.communitywebservice.board.jpa.BoardEntity;

public interface BoardService {

    BoardDto boardRegister(BoardDto boardDto);

    Iterable<BoardEntity> getBoardByAll();

}
