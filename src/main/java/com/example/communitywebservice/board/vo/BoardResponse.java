package com.example.communitywebservice.board.vo;

import lombok.Data;

@Data
public class BoardResponse {

    private String boardId;
    private String boardTitle;
    private String boardContent;
    private String writer;
    private String category;

}
