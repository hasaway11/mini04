package com.example.demo.board;

import lombok.*;

import java.time.*;

@Getter
@Setter
@ToString
public class Board {
  private Integer bno;
  private String title;
  private String content;
  private String nickname;
  private LocalDate writeDay;
  private String password;
  private Integer readCnt;
}
