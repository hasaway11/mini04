package com.example.demo.comment;

import org.springframework.stereotype.*;

//@Service
public class CommentService {
  private CommentDao commentDao;

  boolean deleteByCno(int cno) {
    return commentDao.deleteByCno(cno)>0;
  }
}
