package com.example.communitywebservice.board.service;

import com.example.communitywebservice.board.dto.BoardDto;
import com.example.communitywebservice.board.jpa.BoardEntity;
import com.example.communitywebservice.board.jpa.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Override
    public BoardDto boardRegister(BoardDto boardDto) {

        ModelMapper mapper = new ModelMapper();
        BoardEntity boardEntity = mapper.map(boardDto, BoardEntity.class);

        boardRepository.save(boardEntity);

        BoardDto registedBoard = mapper.map(boardEntity, BoardDto.class);

        return registedBoard;
    }

    @Override
    public Iterable<BoardEntity> getBoardByAll() {
        return boardRepository.findAll();
    }


}
