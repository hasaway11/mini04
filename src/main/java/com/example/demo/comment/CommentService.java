package com.example.demo.comment;

import org.springframework.stereotype.*;

@Service
public class CommentService {
  private CommentDao commentDao;

  public

  public boolean deleteByCno(int cno) {
    return commentDao.deleteByCno(cno)>0;
  }
}
