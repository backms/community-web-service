package com.example.communitywebservice.board.service;

import com.example.communitywebservice.board.dto.BoardDto;
import com.example.communitywebservice.board.jpa.BoardEntity;
import com.example.communitywebservice.board.jpa.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Override
    public BoardDto boardRegister(BoardDto boardDto) {

        ModelMapper mapper = new ModelMapper();

        boardDto.setHitsCnt(1);
        BoardEntity boardEntity = mapper.map(boardDto, BoardEntity.class);

        boardRepository.save(boardEntity);

        BoardDto registedBoard = mapper.map(boardEntity, BoardDto.class);

        return registedBoard;
    }

    @Override
    public Iterable<BoardEntity> getBoardByAll() {
        return boardRepository.findAll();
    }

    @Override
    public BoardDto getBoardById(String writer) {

        BoardEntity boardEntity = boardRepository.findByWriter(writer);

        BoardDto boardDto = new ModelMapper().map(boardEntity, BoardDto.class);

        return boardDto;
    }
}
