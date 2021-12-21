package com.example.communitywebservice.board.dto;

import lombok.Data;

@Data
public class BoardDto {

    private String boardTitle;
    private String boardContents;
    private String writer;
    private String category;

}
