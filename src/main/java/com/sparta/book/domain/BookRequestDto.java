package com.sparta.book.domain;

import lombok.Getter;

@Getter
public class BookRequestDto { //update 용
    private String author;
    private String title;
    private String content;
    private String password;
    private Long id;
}

