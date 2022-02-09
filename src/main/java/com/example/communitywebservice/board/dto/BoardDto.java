package com.example.communitywebservice.board.dto;

import lombok.Data;

@Data
public class BoardDto {

    private String boardTitle;
    private String boardContent;
    private String writer;
    private String category;
    private int hitsCnt;

}
