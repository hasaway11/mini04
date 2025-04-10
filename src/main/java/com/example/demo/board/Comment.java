package com.example.demo.board;

import lombok.*;

import java.time.*;

@Getter
@Setter
public class Comment {
  private Integer cno;
  private String content;
  private String nickname;
  private String password;
  private LocalDateTime writeTime;
  private Integer bno;
}
