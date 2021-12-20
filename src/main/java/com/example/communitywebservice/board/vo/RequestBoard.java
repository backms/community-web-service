package com.example.communitywebservice.board.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestBoard {

    @NotNull
    private String boardTitle;

    @NotNull
    private String boardContent;

    @NotNull
    private String writer;

    @NotNull
    private String category;

}
