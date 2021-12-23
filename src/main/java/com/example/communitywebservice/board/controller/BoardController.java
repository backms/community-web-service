package com.example.communitywebservice.board.controller;

import com.example.communitywebservice.board.dto.BoardDto;
import com.example.communitywebservice.board.jpa.BoardEntity;
import com.example.communitywebservice.board.service.BoardService;
import com.example.communitywebservice.board.vo.RequestBoard;
import com.example.communitywebservice.board.vo.ResponseBoard;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("/board")
    public ResponseEntity<ResponseBoard> boardRegister(@RequestBody RequestBoard requestBoard){

        ModelMapper mapper = new ModelMapper();

        BoardDto boardDto = mapper.map(requestBoard, BoardDto.class);

        boardService.boardRegister(boardDto);

        ResponseBoard responseBoard = mapper.map(boardDto, ResponseBoard.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseBoard);
    }

    @GetMapping("/board")
    public ResponseEntity<List<ResponseBoard>> getBoards() {

        Iterable<BoardEntity> boardList = boardService.getBoardByAll();

        List<ResponseBoard> result = new ArrayList<>();
        boardList.forEach( v -> {
            result.add(new ModelMapper().map(v, ResponseBoard.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
