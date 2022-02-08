package com.example.communitywebservice.board.vo;

import lombok.Data;

@Data
public class ResponseBoard {

    private String boardTitle;
    private String boardContent;
    private String writer;
    private String category;
    private int hitsCnt;

}
